/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeManual;



/**
 * Add your docs here.
 */
public class Intake extends Subsystem {

  private VictorSPX intakeMaster = new VictorSPX(RobotMap.INTAKE_MASTER);

  public Intake() {

    // Direction and Neutral Mode
    intakeMaster.setInverted(true);
    intakeMaster.setNeutralMode(NeutralMode.Brake);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new IntakeManual(-0.15));
    
  }

  public void setIntakePower(double setPower){
    intakeMaster.set(ControlMode.PercentOutput, setPower);
}
 
}
