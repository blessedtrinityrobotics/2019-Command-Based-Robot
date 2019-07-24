/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.WristManual;


/**
 * Add your docs here.
 */
public class Wrist extends Subsystem {
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private  TalonSRX  wristMaster  = new TalonSRX  (RobotMap.WRIST_MASTER);
  private  VictorSPX wristSlave   = new VictorSPX (RobotMap.WRIST_SLAVE);

  public Wrist() {
    wristMaster.setInverted(false);
    wristSlave.setInverted(true);
    wristMaster.setNeutralMode(NeutralMode.Brake);
    wristSlave.setNeutralMode(NeutralMode.Brake);

    //PID

    wristMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); 
    wristMaster.setSensorPhase(false); 
    wristMaster.selectProfileSlot(RobotMap.kSlot_Wrist, RobotMap.PID_PRIMARY);
    wristMaster.config_kP(RobotMap.kSlot_Wrist, RobotMap.kGains_Wrist.kP, RobotMap.kTimeoutMs); 
    wristMaster.config_kI(RobotMap.kSlot_Wrist, RobotMap.kGains_Wrist.kI, RobotMap.kTimeoutMs); 
    wristMaster.config_kD(RobotMap.kSlot_Wrist, RobotMap.kGains_Wrist.kD, RobotMap.kTimeoutMs); 
    wristMaster.config_kF(RobotMap.kSlot_Wrist, RobotMap.kGains_Wrist.kF, RobotMap.kTimeoutMs); 
    wristMaster.configMotionAcceleration(RobotMap.kWristAccel, RobotMap.kTimeoutMs);     
    wristMaster.configMotionCruiseVelocity(RobotMap.kWristVelocity, RobotMap.kTimeoutMs); 
    wristMaster.setSelectedSensorPosition(0, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs);
    

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new WristManual());
  }

  public void setWristPower(double power){
    wristMaster.set(ControlMode.PercentOutput, power);
    wristSlave.follow(wristMaster);
  }

  public void moveToPos(double target){
    wristMaster.set(ControlMode.MotionMagic,target);
    wristSlave.follow(wristMaster);
  }

  public double getAveragePosition(){
    return ( ( wristMaster.getSelectedSensorPosition() + wristMaster.getSelectedSensorPosition() ) /2);

  }
}