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
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private TalonSRX masterLeft = new TalonSRX(RobotMap.MOTOR_LEFT_MASTER_1);
  private VictorSPX slaveLeft1 = new VictorSPX(RobotMap.MOTOR_LEFT_SLAVE_1);
  private VictorSPX slaveLeft2 = new VictorSPX(RobotMap.MOTOR_LEFT_SLAVE_2);

  private TalonSRX masterRight = new TalonSRX(RobotMap.MOTOR_RIGHT_MASTER_1);
  private VictorSPX slaveRight1 = new VictorSPX(RobotMap.MOTOR_RIGHT_SLAVE_1);
  private VictorSPX slaveRight2 = new VictorSPX(RobotMap.MOTOR_RIGHT_SLAVE_2);

  // Starts Gyro
  public ADXRS450_Gyro onboardGyro  = new  ADXRS450_Gyro();
  public double initGyroAngle;
  public double finalGyroAngle;


  public Drivetrain(){
    masterLeft.setInverted(false);
    slaveLeft1.setInverted(false);
    slaveLeft2.setInverted(false);

    masterRight.setInverted(true);
    slaveRight1.setInverted(true);
    slaveRight2.setInverted(true);

    masterLeft.setNeutralMode(NeutralMode.Brake);
    slaveLeft1.setNeutralMode(NeutralMode.Brake);
    slaveLeft2.setNeutralMode(NeutralMode.Brake);

    
    masterRight.setNeutralMode(NeutralMode.Brake);
    slaveRight1.setNeutralMode(NeutralMode.Brake);
    slaveRight2.setNeutralMode(NeutralMode.Brake);

    // Calibrates and Resets Gyro
    onboardGyro.calibrate(); // Calibrates the gyro
    onboardGyro.reset();     // Sets gyro to 0 degrees

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TankDrive());
    
  }

  public void setLeftMotors(double setPower){
    masterLeft.set(ControlMode.PercentOutput, setPower);
    slaveLeft1.follow(masterLeft);
    slaveLeft2.follow(masterLeft);
  }

  public void setRightMotors(double setPower){
    masterRight.set(ControlMode.PercentOutput, setPower);
    slaveRight1.follow(masterRight);
    slaveRight2.follow(masterRight);
  }

  // Sets gyro to 0 degrees
  public void resetGyro(){
    onboardGyro.reset();     
  }

  /**
   * 
   * @return Gyro angle in deg
   * 
   */
  public double getGyroAngle(){
    return onboardGyro.getAngle();
  }
  
  /**
   * 
   * @return Gyro Rate in deg/s
   * 
   */
  public double getGyroRate(){
    return onboardGyro.getRate();
  }

}