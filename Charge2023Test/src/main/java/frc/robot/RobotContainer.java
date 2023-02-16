// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.ChangeArmAngle;
import frc.robot.commands.ChangeLedColor;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Lights;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
  private final XboxController m_driver = new XboxController(DriveConstants.kDriverControllerPort);
  private final XboxController m_operator = new XboxController(DriveConstants.kOperatorControllerPort);

  private final Arm arm;
  private final Lights lights;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    arm = new Arm();
    lights = new Lights();

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    //hot pink
    new JoystickButton(m_operator, Button.kB.value).whileTrue(
        new ChangeLedColor(lights, 0.57));

    //green
    new JoystickButton(m_operator, Button.kY.value).whileTrue(
        new ChangeLedColor(lights, 0.81));

    //yellow
    new JoystickButton(m_operator, Button.kX.value).whileTrue(
        new ChangeLedColor(lights, 0.69));

    //violet
    new JoystickButton(m_operator, Button.kA.value).whileTrue(
        new ChangeLedColor(lights, 0.91));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * 
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {

    // An ExampleCommand will run in autonomous
    return new ExampleCommand(new ExampleSubsystem());

  }

}