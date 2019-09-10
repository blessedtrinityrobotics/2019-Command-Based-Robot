/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.MoveElevToPos;
import frc.robot.commands.WristToPos;
import frc.robot.commands.MoveClimberToPos;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ClimbProcedure extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ClimbProcedure() {
    //addParallel(new MoveClimberToPos(RobotMap.climberUp));
    addParallel(new MoveElevToPos(RobotMap.ClimbElev));
    addParallel(new WristToPos(RobotMap.climbWrist));
  }
}
