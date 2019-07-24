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
//import frc.robot.commands.ElevatorManual;
import frc.robot.commands.MoveElevToPos;


/**
 * Add your docs here.
 */
public class Elevator extends Subsystem {

   private TalonSRX elevLeftMaster = new TalonSRX(RobotMap.ELEV_LEFT_MASTER);
   private VictorSPX elevLeftSlave = new VictorSPX(RobotMap.ELEV_LEFT_SLAVE);

   private TalonSRX elevRightMaster = new TalonSRX(RobotMap.ELEV_RIGHT_MASTER);
   private VictorSPX elevRightSlave = new VictorSPX(RobotMap.ELEV_RIGHT_SLAVE);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Elevator() {

    // Motion Magic 
    // Left
    elevLeftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Starts Encoder
    elevLeftMaster.setSensorPhase(false); // Reverse Directions - FALSE
    elevLeftMaster.selectProfileSlot(RobotMap.kSlot_Elev, RobotMap.PID_PRIMARY); // Profile slot to store PID values on speed controller - MOST IMPORTANT LINE
    elevLeftMaster.config_kP(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kP, RobotMap.kTimeoutMs); // P Gain
    elevLeftMaster.config_kI(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kI, RobotMap.kTimeoutMs); // I Gain
    elevLeftMaster.config_kD(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kD, RobotMap.kTimeoutMs); // D Gain
    elevLeftMaster.config_kF(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kF, RobotMap.kTimeoutMs); // F Gain
    elevLeftMaster.configMotionAcceleration(RobotMap.kElevAccel, RobotMap.kTimeoutMs);      // Motion Magic Acceleration Constant
    elevLeftMaster.configMotionCruiseVelocity(RobotMap.kElevVelocity, RobotMap.kTimeoutMs); // Motion Magic Cruise Velocity Constant
    elevLeftMaster.setSelectedSensorPosition(0, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Sets Encoder to 0 when robot starts
    // Right
    elevRightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Starts Encoder
    elevRightMaster.setSensorPhase(false); // Reverse Directions - FALSE
    elevRightMaster.selectProfileSlot(RobotMap.kSlot_Elev, RobotMap.PID_PRIMARY); // Profile slot to store PID values on speed controller - MOST IMPORTANT LINE
    elevRightMaster.config_kP(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kP, RobotMap.kTimeoutMs); // P Gain
    elevRightMaster.config_kI(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kI, RobotMap.kTimeoutMs); // I Gain
    elevRightMaster.config_kD(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kD, RobotMap.kTimeoutMs); // D Gain
    elevRightMaster.config_kF(RobotMap.kSlot_Elev, RobotMap.kGains_Elev.kF, RobotMap.kTimeoutMs); // F Gain
    elevRightMaster.configMotionAcceleration(RobotMap.kElevAccel, RobotMap.kTimeoutMs);      // Motion Magic Acceleration Constant
    elevRightMaster.configMotionCruiseVelocity(RobotMap.kElevVelocity, RobotMap.kTimeoutMs); // Motion Magic Cruise Velocity Constant
    elevRightMaster.setSelectedSensorPosition(0, RobotMap.PID_PRIMARY, RobotMap.kTimeoutMs); // Sets Encoder to 0 when robot starts

    // Direction and Neutral Mode
    //Left
    elevLeftMaster.setInverted(false);
    elevLeftSlave.setInverted(true);
    elevLeftMaster.setNeutralMode(NeutralMode.Brake);
    elevLeftSlave.setNeutralMode(NeutralMode.Brake);
    // Right
    elevRightMaster.setInverted(false);
    elevRightSlave.setInverted(true);
    elevRightMaster.setNeutralMode(NeutralMode.Brake);
    elevRightSlave.setNeutralMode(NeutralMode.Brake);
  
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveElevToPos(0.0));
  }

  public void setElevLeft(double setPower){
    elevLeftMaster.set(ControlMode.PercentOutput, setPower);
    elevLeftSlave.follow(elevLeftMaster);
  }

  public void setElevRight(double setPower){
    elevRightMaster.set(ControlMode.PercentOutput, -setPower);
    elevRightSlave.follow(elevRightMaster);
  }

  public void moveToPos(double target){
    elevLeftMaster.set(ControlMode.MotionMagic, target);  // Need to confirm direction (from old code)
    elevLeftSlave.follow(elevLeftMaster);
    elevRightMaster.set(ControlMode.MotionMagic, target); // Need to confirm direction (from old code)
    elevRightSlave.follow(elevRightMaster);
  }

  public double getAvgPosition(){
    return ( ( elevLeftMaster.getSelectedSensorPosition() + elevRightMaster.getSelectedSensorPosition() ) /2);
  }
  
}
