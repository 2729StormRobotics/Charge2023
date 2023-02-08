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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commandgroups.AutoDriveBackwards;
import frc.robot.commandgroups.DriveBackwardsAndBalance;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.DriveManuallyArcade;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.PointTurnGyroTank;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static frc.robot.commandgroups.AutoDriveBackwards.*;


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

  private final Drivetrain m_drivetrain;

  // private final Index m_index;
  // private final Intake m_intake;
  // private final Shooter m_shooter;
  // private final Vision m_vision;
  // private final Compressor m_testCompressor;

  private final SendableChooser<Command> m_autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_drivetrain = new Drivetrain();
    // m_index = new Index();
    // m_intake = new Intake();
     //m_vision = new Vision();
    // m_shooter = new Shooter();

    m_autoChooser = new SendableChooser<>();
    SmartDashboard.putData("Autonomous Selector", m_autoChooser);
    //m_autoChooser.setDefaultOption("Do Nothing", new InstantCommand());
    m_autoChooser.setDefaultOption("DriveBackwardsAndBalance", new DriveBackwardsAndBalance(m_drivetrain));
   // m_autoChooser.addOption("Wall Shot", new AutoWallShot(m_shooter, m_index, m_drivetrain, m_intake, m_vision));

    m_drivetrain.setDefaultCommand(
        new DriveManuallyArcade(() -> m_driver.getLeftY(), () -> m_driver.getRightX(), m_drivetrain));

    // Configure the button bindings
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

    
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    
    // An ExampleCommand will run in autonomous
    return m_autoChooser.getSelected();

  }

}