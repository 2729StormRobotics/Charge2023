// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.changeArmAngle;
import frc.robot.commands.telescopeToDistance;
import frc.robot.subsystems.Arm;
import static frc.robot.Constants.ArmConstants.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html

// This command group positions the arm to balance out the robot when driving onto the Charge Station.

public class chargeArm extends ParallelCommandGroup {

  private final Arm m_arm;

  /** Creates a new chargeArm. */
  public chargeArm(Arm arm) {

    m_arm = arm;

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new changeArmAngle(m_arm, chargingAngle), new telescopeToDistance(m_arm, chargingExtensionDistance));
  }
}
