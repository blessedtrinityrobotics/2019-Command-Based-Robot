/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command; 
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import frc.robot.RobotMap;
import frc.robot.OI;;

public class ElevatorMove extends Command {
  public ElevatorMove() {
    // test comment
    // Use requires() here to declare subsystem dependencies
    requires(Robot.elevTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftStickY = Robot.m_oi.getAxisOperator(RobotMap.leftStickY);
    double rightStickY = Robot.m_oi.getAxisOperator(RobotMap.rightStickY);

    Robot.elevTrain.moveElevLeft(leftStickY);
    Robot.elevTrain.moveElevRight(rightStickY);
  }
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}