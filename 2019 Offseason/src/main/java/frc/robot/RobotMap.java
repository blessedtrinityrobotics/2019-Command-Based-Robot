/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int MOTOR_LEFT_MASTER_1 = 2;
	public static final int MOTOR_LEFT_SLAVE_1 = 4;
  public static final int MOTOR_LEFT_SLAVE_2 = 6;
  
  public static final int MOTOR_RIGHT_MASTER_1 = 3;
	public static final int MOTOR_RIGHT_SLAVE_1 = 5 ;
  public static final int MOTOR_RIGHT_SLAVE_2 = 7;
  
  public static final int DRIVER_CONTROLLER = 0;
  public static final int OPERATOR_CONTROLLER = 1;



  public static final double turningPower = 0.5;
  

  public static final int leftStickX       = 0;  
  public static final int leftStickY       = 1;
  public static final int leftTriggerAxis  = 2;
  public static final int rightTriggerAxis = 3;
  public static final int rightStickX      = 4;
  public static final int rightStickY      = 5;




  public static final int ELEV_RIGHT_MASTER = 9;
  public static final int ELEV_RIGHT_SLAVE = 10;
  public static final int ELEV_LEFT_MASTER = 8;
  public static final int ELEV_LEFT_SLAVE = 11;


  public static final int WRIST_MASTER = 13;
  public static final int WRIST_SLAVE = 12; 

  public static final int INTAKE_MASTER = 14;

  




  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;



  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}