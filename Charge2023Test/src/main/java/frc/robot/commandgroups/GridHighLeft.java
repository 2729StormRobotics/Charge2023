// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ChangeArmAngle;
import frc.robot.commands.PointTurnGyroTank;
import frc.robot.commands.TelescopeToDistance;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.Constants.ArmConstants.*;
import static frc.robot.Constants.DriveConstants.kTurnSpeed;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html

// This command group positions the arm to the high level of the grid in the left position.

public class GridHighLeft extends ParallelCommandGroup {

  private final Arm m_arm;
  private final Drivetrain m_drivetrain;

  /** Creates a new gridHighLeft. */
  public GridHighLeft(Arm arm, Drivetrain drivetrain) {

    m_arm = arm;
    m_drivetrain = drivetrain;

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new PointTurnGyroTank(kTurnSpeed, leftHorizontalShift, m_drivetrain), new ChangeArmAngle(m_arm, highConeAngle), new TelescopeToDistance(m_arm, highExtensionDistance)); 
      }
}
