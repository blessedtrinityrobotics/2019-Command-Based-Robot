/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command; 
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystem.Wrist;
import frc.robot.Robot.Oi;


public class WristManual extends Command {
  double targetPos;
  public WristManual(double target) {
      targetPos = target;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    boolean leftBumperOperator =  Robot.m_oi.getLeftBumperOperator();
    boolean rightBumperOrerator = Robot.m_oi.getRightBumperOperator();

        if(leftBumperOperator == true)
        {
            targetPos = TravelWrist;
        }

        else if(rightBumperOrerator == true)
        {
            targetPos = CargoWrist;
        }
    Robot.wrist.moveToPos(targetPos);
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  Robot.wrist.moveToPos(targetPos);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.wrist.setElevLeft(0.0);
    Robot.wrist.setElevRight(0.0);
  }
}