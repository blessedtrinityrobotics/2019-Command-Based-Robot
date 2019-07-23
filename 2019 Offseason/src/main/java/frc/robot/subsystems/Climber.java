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
import frc.robot.commands.MoveClimberToPos;;


/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  private TalonSRX climbMotorMaster = new TalonSRX(RobotMap.CLIMB_MOTOR_MASTER);
  private VictorSPX climbMotorSlave = new VictorSPX(RobotMap.CLIMB_MOTOR_SLAVE);
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Climber(){

    climbMotorMaster.setInverted(false);
    climbMotorSlave.setInverted(false);
    
    climbMotorMaster.setNeutralMode(NeutralMode.Brake);
    climbMotorSlave.setNeutralMode(NeutralMode.Brake);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new MoveClimberToPos(0.0));
    
  }

  public void setClimbMotors(double setPower){
    climbMotorMaster.set(ControlMode.PercentOutput, setPower);
    climbMotorSlave.follow(climbMotorMaster);

  }

  public void MoveClimberToPos(double setpoint){
    double target = setpoint;
    climbMotorMaster.set(ControlMode.MotionMagic, target);
    climbMotorSlave.follow(climbMotorMaster);
  }

  public double getAvgPosition(){
    return ( ( climbMotorMaster.getSelectedSensorPosition() + climbMotorSlave.getSelectedSensorPosition() ) /2);
  }
 
}