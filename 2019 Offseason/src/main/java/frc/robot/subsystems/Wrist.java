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
import frc.robot.commands.WristManual;


/**
 * Add your docs here.
 */
public class Wrist extends Subsystem {
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private  TalonSRX  wristMaster  = new TalonSRX  (RobotMap.WRIST_MASTER);
  private  VictorSPX wristSlave   = new VictorSPX (RobotMap.WRIST_SLAVE);

  public Wrist() {
    wristMaster.setInverted(false);
    wristSlave.setInverted(true);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new WristManual());
  }

  public void setWristPower(double power){
    wristMaster.set(ControlMode.PercentOutput, power);
    wristSlave.follow(wristMaster);
  }
}