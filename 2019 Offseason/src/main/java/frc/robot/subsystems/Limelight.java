/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public boolean IsTargetValid = false;
  public boolean LEDStatus = true; 
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new MySpecialCommand());
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
