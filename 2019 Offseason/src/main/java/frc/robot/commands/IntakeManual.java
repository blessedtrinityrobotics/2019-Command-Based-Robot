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
import frc.robot.subsystems.Intake;
import frc.robot.OI; 
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class IntakeManual extends Command {
  public IntakeManual() {
    // test comment
    // Use requires() here to declare subsystem dependencies
    requires(Robot.intake);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

  boolean leftBumperDriver =  Robot.m_oi.getLeftBumperDriver();
  boolean rightBumperDriver = Robot.m_oi.getRightBumperDriver();

  if(leftTriggerOperator==true)
  {
    Robot.intake.setIntakePower(.5);
  }

  else if(rightTriggerOperator==true)
  {
    Robot.intake.setIntakePower(-.5);
  }
  else
  {
    Robot.intake.setIntakePower(0.0);
  }

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
    robot.intake.setIntakePower(0.0)
  }
}