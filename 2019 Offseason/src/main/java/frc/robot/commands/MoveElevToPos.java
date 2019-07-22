/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command; 
import frc.robot.Robot;


public class MoveElevToPos extends Command {
  double targetPos;
  public MoveElevToPos(double target) {
      targetPos = target;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevator);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      Robot.elevator.moveToPos(targetPos);
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    double currentPostion = Robot.elevator.getAvgPosition();
    if( ( currentPostion > targetPos - 100 /* MIN */ ) && ( currentPostion < targetPos + 100 /* MAX */ ) ) {
      return true;
    } else {
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevator.moveToPos(targetPos);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.elevator.setElevLeft(0.0);
    Robot.elevator.setElevRight(0.0);
  }
}