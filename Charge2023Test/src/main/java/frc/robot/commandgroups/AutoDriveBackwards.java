// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//package frc.robot.commandgroups;


package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.PointTurnGyroPID;
import frc.robot.commands.PointTurnGyroTank;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoDriveBackwards extends SequentialCommandGroup {
  /** Creates a new AutoDriveBackwards. */
  public AutoDriveBackwards(Drivetrain drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

  //  addCommands(new DriveDistance(drivetrain, -0.3, 50));
  //  addCommands(new PointTurnGyroTank(0.6, 90, drivetrain));
  addCommands(new PointTurnGyroPID(90, drivetrain));

    //addCommands(new DriveDistance(drivetrain, -0.3, 50));
   // addCommands(new PointTurnGyroTank(0.6, 90, drivetrain));

  }
}