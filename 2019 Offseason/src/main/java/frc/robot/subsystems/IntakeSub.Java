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

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorMove;


/**
 * Add your docs here.
 */
public class IntakeSub extends Subsystem {

  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public IntakeSub() {
    private TalonSRX intakeMaster = new TalonSRX(RobotMap.INTAKE_MASTER);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new ElevatorMove());
    intakeMaster.setInverted(true);
  }

  public void setIntakePower(double setPower){
    intakeMaster.set(ControlMode.PercentOutput, setPower);
}
 
}
