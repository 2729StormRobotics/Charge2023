// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import java.util.logging.Handler;
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commandgroups.AutoDriveBackwards;
import frc.robot.commandgroups.ChargeArm;
import frc.robot.commandgroups.GridConeMid;
import frc.robot.commandgroups.GridLow;
import frc.robot.commandgroups.ShelfPickup;
//import frc.robot.commandgroups.GridConeMid;
//import frc.robot.commandgroups.GridCubeHigh;
//import frc.robot.commandgroups.GridCubeMid;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Claw;

//import frc.robot.commands.ChangeArmAngle;
import frc.robot.commands.DriveManuallyArcade;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ClawConePickup;
import frc.robot.commands.ClawEject;
import frc.robot.commands.ClawPickup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.PointTurnGyroPID;
import frc.robot.commands.PointTurnGyroTank;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commandgroups.AutoDriveBackwards;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveManuallyArcade;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.PointTurnGyroTank;

import static frc.robot.Constants.*;
import static frc.robot.Constants.DriveConstants.*;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final XboxController m_driver = new XboxController(DriveConstants.kDriverControllerPort);
  private final XboxController m_operator = new XboxController(DriveConstants.kOperatorControllerPort);


  private final Arm arm;
  private final Claw claw;
  private final Drivetrain m_drivetrain;


  private final double straightSpeedFactor = 0.6;
  private final double turnSpeedFactor = 0.5;
  private final double straightDecelSpeedFactor = 0.7;
  private final double turnDecelSpeedFactor = 0.4;

 

  // private final Index m_index;
  // private final Intake m_intake;
  // private final Shooter m_shooter;
  // private final Vision m_vision;
  // private final Compressor m_testCompressor;

  private final SendableChooser<Command> m_autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    arm = new Arm();
    m_drivetrain = new Drivetrain();
    claw = new Claw();

    m_autoChooser = new SendableChooser<>();
    SmartDashboard.putData("Autonomous Selector", m_autoChooser);
   
 


    m_drivetrain.setDefaultCommand(
        new DriveManuallyArcade(() -> m_driver.getLeftY(), () -> m_driver.getRightX(), m_drivetrain));

    SmartDashboard.putData("Autonomous Selector", m_autoChooser);
  


    m_drivetrain.setDefaultCommand(
        new DriveManuallyArcade(() -> m_driver.getLeftY(), () -> m_driver.getRightX(), m_drivetrain));


    // Configure the button bindings
    configureButtonBindings();

  }

  //TAHA WUZ HERE!!! 

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * @return 
   */


  private void configureButtonBindings() {
    new Trigger(() -> (m_driver.getLeftTriggerAxis() > 0.01))
        .onTrue(new DriveManuallyArcade(() -> (m_driver.getLeftY() * straightDecelSpeedFactor),
        () -> (-m_driver.getRightX() * turnDecelSpeedFactor), m_drivetrain));
    //Holding the trigger slows the speed in which the drivetrain travels in. If true, the drive train will travel at a decellerated speed. Press Again to return to normal operation. 

    

   /* Trigger aOpButton = new JoystickButton(m_operator, Button.kA.value).onTrue(
      new ChangeArmAngle(arm, arm.getArmAngle() + 30);

    new JoystickButton(m_operator, Button.kB.value).whileTrue(
      new ChangeArmAngle(arm, arm.getArmAngle() - 30));

      */

      //add vision button binding (Either A,B, or X button Driver)

//add dock and engage button binding (Y-Button Driver)

//****Operator Controller Button bindings****
//bOpButton
//new JoystickButton(m_operator, Button.kB.value).onTrue(new GridCubeMid(arm, drivetrain));
    




//xOpButton 
new JoystickButton(m_operator, Button.kX.value).onTrue(new GridConeMid(arm, m_drivetrain));

//aOpButton  
new JoystickButton(m_operator, Button.kA.value).onTrue(new GridLow(arm,m_drivetrain));
    
//rBumpOpButton
 new JoystickButton(m_operator, Button.kRightBumper.value).onTrue(new ClawPickup(claw));

    
//rOpTrigger
new Trigger(() -> (m_operator.getRightTriggerAxis() > 0.01))
        .whileTrue(new ClawConePickup(claw));

//lOpTrigger
 new Trigger(() -> (m_operator.getLeftTriggerAxis() > 0.01))
        .whileTrue(new ClawEject(claw));

//downopDpad -- down d-pad button
new POVButton(m_operator, 180).onTrue(new ChargeArm(arm));
      
//leftopDpad left d-pad button
new POVButton(m_operator, 270).whileTrue(new ShelfPickup(arm));
     
      }



/**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    
    // An ExampleCommand will run in autonomous
    return m_autoChooser.getSelected();

  }

}