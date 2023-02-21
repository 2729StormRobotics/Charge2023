// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawCubePickup extends CommandBase {
  private static final double kRollerMotorStopSpeed = 0;
  private final Claw m_claw;

  /** Creates a new ClawCubePickup. */
  public ClawCubePickup(Claw subsystem) {

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
    //motors run at a given speed and then stop once it recognizes that it is holding a cube.
m_claw.runRollerMotors(0);

m_claw.stopRollerMotorsCube(kRollerMotorStopSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_claw.haltMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}