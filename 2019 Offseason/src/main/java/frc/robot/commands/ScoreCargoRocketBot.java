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
import frc.robot.RobotMap;
import frc.robot.commands.IntakeManual;
public class ScoreCargoRocketBot extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ScoreCargoRocketBot() {
    addParallel(new MoveElevToPos(RobotMap.LowElev));
    addParallel(new WristToPos(RobotMap.ScoreCargoRocket)); // Run Intake
    //addSequential(new IntakeManual(0.5)); // Run Bottom Rollers on hopper
  }
}
