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

// Ports  

	public static final int MOTOR_LEFT_MASTER_1 = 2;
	public static final int MOTOR_LEFT_SLAVE_1  = 4;
  public static final int MOTOR_LEFT_SLAVE_2  = 6;
  
  public static final int MOTOR_RIGHT_MASTER_1 = 3;
	public static final int MOTOR_RIGHT_SLAVE_1  = 5 ;
  public static final int MOTOR_RIGHT_SLAVE_2  = 7;
  
  public static final int DRIVER_CONTROLLER   = 0;
  public static final int OPERATOR_CONTROLLER = 1;

  public static final double TURNING_POWER = 0.5;
  
  public static final int LEFT_STICK_X       = 0;  
  public static final int LEFT_STICK_Y       = 1;
  public static final int LEFT_TRIGGER_AXIS  = 2;
  public static final int RIGHT_TRIGGER_AXIS = 3;
  public static final int RIGHT_STICK_X      = 4;
  public static final int RIGHT_STICK_Y      = 5;

  public static final int aButton           = 1;
  public static final int bButton           = 2;
  public static final int xButton           = 3;
  public static final int yButton           = 4;
  public static final int leftBumperButton  = 5;
  public static final int rightBumperButton = 6;
  public static final int backButton        = 7;
  public static final int startButton       = 8;
  public static final int leftStickButton   = 9;
  public static final int rightStickButton  = 10;

  public static final int ELEV_RIGHT_MASTER = 9;
  public static final int ELEV_RIGHT_SLAVE  = 10;
  public static final int ELEV_LEFT_MASTER  = 8;
  public static final int ELEV_LEFT_SLAVE   = 11;

  public static final int WRIST_MASTER = 13;
  public static final int WRIST_SLAVE  = 12; 

  public static final int INTAKE_MASTER = 14;

  public static final int CLIMB_MOTOR_MASTER = 15;
  public static final int CLIMB_MOTOR_SLAVE  = 16;  

  public static final double BotElev = 0;
  public static final double LowElev = 1000;
  public static final double MidElev = 5000;
  public static final double TopElev = 10000;

  public static final double RetractWrist = 0;
  public static final double TravelWrist  = 200;
  public static final double CargoWrist   = 300;
  public static final double HatchWrist   = 1000;

// End of Ports

// PID/Motion Magic Constants
  public final static int kTimeoutMs = 30;
    
  // DriveTrain Motion Magic Constants
  public final static int kDriveTrainSensorVel = 1000;
  public final static int kDriveTrainAccel     = kDriveTrainSensorVel/2;
  public final static int kDriveTrainVelocity  = kDriveTrainSensorVel/2;

  // Elevator Motion Magic Constants
  public final static int kElevSensorVel = 3410;
  public final static int kElevAccel     = kElevSensorVel/2;
  public final static int kElevVelocity  = kElevSensorVel/2;

  // Wrist Motion Magic Constants
  public final static int kWristSensorVel  = 399;
  public final static int kWristAccel = kWristSensorVel/2;
  public final static int kWristVelocity   = kWristSensorVel/2;

  // Climb Motion Magic Constants
  public final static int kClimbSensorVel  = 399;
  public final static int kClimbAccel = kClimbSensorVel/2;
  public final static int kClimbVelocity   = kClimbSensorVel/2;
  /**
  * PID Gains may have to be adjusted based on the responsiveness of control loop.
  * kF: 1023 represents output value to Talon at 100%, 6800 represents Velocity units at 100% output
  * Not all set of Gains are used in this project and may be removed as desired.
  *                                 	                 kP   kI    kD   kF                    Iz    PeakOut */
  public final static Gains kGains_Drive  = new Gains( 0.0, 0.0,  0.0, 0.0,                  100,  0.50 );
  public final static Gains kGains_Elev   = new Gains( 1.5, 0.0,  0.0, 1023/kElevSensorVel,  100,  0.50 );
  public final static Gains kGains_Wrist  = new Gains( 0.0, 0.0,  0.0, 1023/kWristSensorVel, 100,  0.50 );
  public final static Gains kGains_Climb  = new Gains( 0.0, 0.0,  0.0, 1023/kWristSensorVel, 100,  0.50 );

  /** ---- Flat constants, you should not need to change these ---- */
  /* We allow either a 0 or 1 when selecting an ordinal for remote devices [You can have up to 2 devices assigned remotely to a talon/victor] */
  public final static int REMOTE_0 = 0;
  public final static int REMOTE_1 = 1;

  /* We allow either a 0 or 1 when selecting a PID Index, where 0 is primary and 1 is auxiliary */
  public final static int PID_PRIMARY = 0;
  public final static int PID_TURN    = 1;

  /* ---- Named slots, used to clarify code ---- */
  public final static int kSlot_Drive = 0;
  public final static int kSlot_Elev  = 0;
  public final static int kSlot_Wrist = 0;
  public final static int kSlot_Climb = 0;

// End of PID/Motion Magic Constants


}