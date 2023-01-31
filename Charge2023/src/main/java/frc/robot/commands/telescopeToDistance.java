// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import static frc.robot.Constants.ArmConstants.*;

public class telescopeToDistance extends CommandBase {

  private Arm m_Arm;

  private double distance;

  /** Creates a new telescopeToDistance. */
  public telescopeToDistance(Arm subsystem, double dist) {

    m_Arm = subsystem;
    distance = dist;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_Arm.setAngleMotorSpeed(0);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_Arm.setAngleMotorSpeed((distance > m_Arm.getStringPotDistance() ? kAngleMotorSpeed : -kAngleMotorSpeed));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_Arm.setAngleMotorSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return (m_Arm.getStringPotDistance() >= kMaxExtensionLength || m_Arm.getStringPotDistance() <= 0);

  }

}
