/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClimberManual;
import frc.robot.commands.MoveClimberToPos;;


/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  private TalonSRX climbMotorMaster = new TalonSRX(RobotMap.CLIMB_MOTOR_MASTER);
  private VictorSPX climbMotorSlave = new VictorSPX(RobotMap.CLIMB_MOTOR_SLAVE);
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Climber(){

    climbMotorMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Starts Encoder
    climbMotorMaster.setSensorPhase(false); // Reverse Directions - FALSE
    climbMotorMaster.selectProfileSlot(RobotMap.kSlot_Climb, RobotMap.PID_PRIMARY); // Profile slot to store PID values on speed controller - MOST IMPORTANT LINE
    climbMotorMaster.config_kP(RobotMap.kSlot_Climb, RobotMap.kGains_Climb.kP, RobotMap.kTimeoutMs); // P Gain
    climbMotorMaster.config_kI(RobotMap.kSlot_Climb, RobotMap.kGains_Climb.kI, RobotMap.kTimeoutMs); // I Gain
    climbMotorMaster.config_kD(RobotMap.kSlot_Climb, RobotMap.kGains_Climb.kD, RobotMap.kTimeoutMs); // D Gain
    climbMotorMaster.config_kF(RobotMap.kSlot_Climb, RobotMap.kGains_Climb.kF, RobotMap.kTimeoutMs); // F Gain
    climbMotorMaster.configMotionAcceleration(RobotMap.kClimbAccel, RobotMap.kTimeoutMs);      // Motion Magic Acceleration Constant
    climbMotorMaster.configMotionCruiseVelocity(RobotMap.kClimbVelocity, RobotMap.kTimeoutMs); // Motion Magic Cruise Velocity Constant
    climbMotorMaster.setSelectedSensorPosition(0, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Sets Encoder to 0 when robot starts

    climbMotorMaster.setInverted(false);
    climbMotorSlave.setInverted(false);
    
    climbMotorMaster.setNeutralMode(NeutralMode.Brake);
    climbMotorSlave.setNeutralMode(NeutralMode.Brake);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MoveClimberToPos(0.0));
    
  }

  public void setClimbMotors(double setPower){
    climbMotorMaster.set(ControlMode.PercentOutput, setPower);
    climbMotorSlave.follow(climbMotorMaster);

  }

  public void MoveClimberToPos(double setpoint){
    double target = setpoint;
    climbMotorMaster.set(ControlMode.MotionMagic, target);
    climbMotorSlave.follow(climbMotorMaster);
  }

  public double getAvgPosition(){
    return climbMotorMaster.getSelectedSensorPosition();
  }
 
}