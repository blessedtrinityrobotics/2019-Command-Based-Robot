/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ValidTarget;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public boolean m_LimelightHasValidTarget = false;
  public boolean IsTargetValid = false;
  public boolean LEDStatus = true; 
  double STEER_INTEGRAL;
  double STEER_DERIVATIVE;
  double STEER_ERROR_PRIOR;
  public double steer_cmd;
  public double drive_cmd;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ValidTarget());
  }

  /**
   * This function implements a simple method of generating driving and steering commands
   * based on the tracking data from a limelight camera.
  */
  public void approachTargetWithVision() {
    final double STEER_P = 0.005;                    
    final double DRIVE_P = 0.05;                     
    final double DESIRED_TARGET_AREA = 4;         // Area of the target when the robot reaches the wall
    final double MAX_DRIVE = 0.75;                   // Simple speed limit so we don't drive too fast
    final double STEER_I = 0.005;
    final double DRIVE_I = 0.0;
    final double STEER_D = 0.02;
    final double xError;
    final double aError;
    double DRIVE_INTEGRAL = 0;

    

    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
    xError = tx;
    aError = (DESIRED_TARGET_AREA - ta);
    // SmartDashboard.putNumber("TA", ta);
    // SmartDashboard.putNumber("TA Error", aError);
    SmartDashboard.putNumber("TX Error", xError);
    STEER_INTEGRAL = STEER_INTEGRAL + (xError*0.02);
    DRIVE_INTEGRAL = DRIVE_INTEGRAL + (aError * 0.02);
    STEER_DERIVATIVE = (xError - STEER_ERROR_PRIOR)/0.02;
    SmartDashboard.putNumber("Integral", STEER_INTEGRAL);
    SmartDashboard.putNumber("Derivative", STEER_DERIVATIVE);
    SmartDashboard.putNumber("TA", ta);


    if (tv < 1.0) {
      m_LimelightHasValidTarget = false;
      drive_cmd = 0.0;
      steer_cmd = 0.0;
    } else {
      m_LimelightHasValidTarget = true;
      // Start with proportional steering
      steer_cmd = (xError * STEER_P) + (STEER_INTEGRAL * STEER_I) + (STEER_DERIVATIVE * STEER_D);

      // try to drive forward until the target area reaches our desired area
      drive_cmd = (aError * DRIVE_P) + (DRIVE_INTEGRAL * DRIVE_I);
      // don't let the robot drive too fast into the goal
      if (drive_cmd > MAX_DRIVE){
        drive_cmd = MAX_DRIVE;
      }
    }

    Robot.driveTrain.setLeftMotors(-drive_cmd - steer_cmd);
    Robot.driveTrain.setRightMotors(-drive_cmd + steer_cmd);

    STEER_ERROR_PRIOR = xError;

  }

  public void clearVars(){
    STEER_INTEGRAL = 0;
    STEER_DERIVATIVE = 0;
  }


  public boolean IsTarget(){

    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

    if(tv>=1.00)
    {
    SmartDashboard.putBoolean("ValidVisionTarget", true);  
    return true;
    }

    else
    {
    SmartDashboard.putBoolean("ValidVisionTarget", false); 
    return false;
    }

  }

  public void toggleVision(){

    if(LEDStatus)
    {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    LEDStatus=false; 
    }

    else
    {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);  
    LEDStatus=true; 
    }

  }
}
