/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClimbProcedure;
import frc.robot.commands.IntakeManual;
import frc.robot.commands.IntakeProcedure;
import frc.robot.commands.MoveClimberToPos;
import frc.robot.commands.MoveElevToPos;
import frc.robot.commands.PushRobotOnHab;
import frc.robot.commands.ResetMechanism;
import frc.robot.commands.ScoreCargo;
import frc.robot.commands.ScoreCargoRocketBot;
import frc.robot.commands.ToggleLight;
import frc.robot.commands.WristToPos;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  private XboxController driver = new XboxController(RobotMap.DRIVER_CONTROLLER);
  private XboxController operator = new XboxController(RobotMap.OPERATOR_CONTROLLER);


  public double getAxis(int axis){
    return driver.getRawAxis(axis);
  }

  public double getAxisOperator(int axis){
    return operator.getRawAxis(axis);
  }



  // Starts Driver Buttons
  Button xButtonDriver             = new JoystickButton(driver, RobotMap.xButton);
  Button aButtonDriver             = new JoystickButton(driver, RobotMap.aButton);
  Button bButtonDriver             = new JoystickButton(driver, RobotMap.bButton);
  Button yButtonDriver             = new JoystickButton(driver, RobotMap.yButton);
  Button backButtonDriver          = new JoystickButton(driver, RobotMap.backButton);
  Button startButtonDriver         = new JoystickButton(driver, RobotMap.startButton);
  Button leftBumperButtonDriver    = new JoystickButton(driver, RobotMap.leftBumperButton);
  Button rightBumperButtonDriver   = new JoystickButton(driver, RobotMap.rightBumperButton);
  Button leftStickButtonDriver     = new JoystickButton(driver, RobotMap.leftStickButton);
  Button rightStickButtonDriver    = new JoystickButton(driver, RobotMap.rightStickButton);

  // Starts Operator Buttons
  Button xButtonOperator           = new JoystickButton(operator, RobotMap.xButton);
  Button aButtonOperator           = new JoystickButton(operator, RobotMap.aButton);
  Button bButtonOperator           = new JoystickButton(operator, RobotMap.bButton);
  Button yButtonOperator           = new JoystickButton(operator, RobotMap.yButton);
  Button backButtonOperator        = new JoystickButton(operator, RobotMap.backButton);
  Button startButtonOperator       = new JoystickButton(operator, RobotMap.startButton);
  Button leftBumperButtonOperator  = new JoystickButton(operator, RobotMap.leftBumperButton);
  Button rightBumperButtonOperator = new JoystickButton(operator, RobotMap.rightBumperButton);
  Button leftStickButtonOperator   = new JoystickButton(operator, RobotMap.leftStickButton);
  Button rightStickButtonOperator  = new JoystickButton(operator, RobotMap.rightStickButton);

  public OI(){
/*
    // Starts Commands
    aButtonOperator.whenPressed(new MoveElevToPos(RobotMap.BotElev)); // All the way down
    bButtonOperator.whenPressed(new MoveElevToPos(RobotMap.LowElev)); // Low position
    yButtonOperator.whenPressed(new MoveElevToPos(RobotMap.MidElev)); // Mid Position
    xButtonOperator.whenPressed(new MoveElevToPos(RobotMap.TopElev)); // Top Position

    //Bumpers for Wrist
    leftBumperButtonOperator.whenPressed(new WristToPos(RobotMap.CargoWrist)); // Cargo Wrist
    rightBumperButtonOperator.whenPressed(new WristToPos(RobotMap.TravelWrist)); // Travelling Wrist

    //Intake for Intake
    //startButtonOperator.whenPressed(new IntakeProcedure(.5)); //Move Wrist Up and Intake the Ball
    //rightBumperButtonDriver.whenPressed(new IntakeManual(-.5)); //Intake Speed -

    //Intake
    startButtonOperator.whileHeld(new IntakeManual(0.5));
    backButtonOperator.whileHeld(new IntakeManual(-0.5));
  */
  

  // Procedures
  aButtonOperator.whenPressed(new IntakeProcedure());
  yButtonOperator.whenPressed(new ScoreCargo());
  bButtonOperator.whenPressed(new ScoreCargoRocketBot());
  xButtonOperator.whenPressed(new ResetMechanism());
  rightBumperButtonDriver.whenPressed(new IntakeManual(0.5));
  

  // Climber
  leftBumperButtonOperator.whenPressed(new ClimbProcedure());
  rightBumperButtonOperator.whenPressed(new MoveClimberToPos(RobotMap.climberDown));
  
  backButtonOperator.whenPressed(new PushRobotOnHab());

  // Limelight
  xButtonDriver.whenPressed(new ToggleLight());
  }

}
