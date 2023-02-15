// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.PIDarcadepointturn;
import frc.robot.commands.PointTurnGyroPID;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.PIDarcadepointturn;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PIDPointturncommand extends SequentialCommandGroup {
  /** Creates a new PIDPointturn. */
  public PIDPointturncommand(Drivetrain drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    // int angle = 90;
     addCommands(new PIDarcadepointturn(drivetrain, 90) );

    // angle += 90;
    
 

  }

}
