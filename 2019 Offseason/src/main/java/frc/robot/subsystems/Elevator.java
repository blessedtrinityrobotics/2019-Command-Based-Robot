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
public class Elevator extends Subsystem {

   private TalonSRX elevLeftMaster = new TalonSRX(RobotMap.ELEV_LEFT_MASTER);
   private VictorSPX elevLeftSlave = new VictorSPX(RobotMap.ELEV_LEFT_SLAVE);

   private TalonSRX elevRightMaster = new TalonSRX(RobotMap.ELEV_RIGHT_MASTER);
   private VictorSPX elevRightSlave = new VictorSPX(RobotMap.ELEV_RIGHT_SLAVE);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorMove());

    elevLeftMaster.setInverted(false);
    elevLeftSlave.setInverted(true);

    elevRightMaster.setInverted(false);
    elevRightSlave.setInverted(true);
  }

  public void setElevLeft(double setPower){
    elevLeftMaster.set(ControlMode.PercentOutput, setPower);
    elevLeftSlave.follow(elevLeftMaster);
  }

  public void setElevRight(double setPower){
    elevRightMaster.set(ControlMode.PercentOutput, -setPower);
    elevRightSlave.follow(elevRightMaster);
  }
  
}