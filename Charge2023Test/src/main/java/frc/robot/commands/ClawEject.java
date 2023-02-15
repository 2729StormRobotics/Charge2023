// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawEject extends CommandBase {
  private static final double kshootSpeed = 0;
  private final Claw m_claw;

  /** Creates a new ClawPickup. */
  public ClawEject(Claw subsystem) {

    m_claw = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.

  addRequirements(m_claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_claw.ejectRollerMotors(kshootSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_claw.retractLeftPiston();
    m_claw.retractRightPiston();
    m_claw.haltMotors(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}