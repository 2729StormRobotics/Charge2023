// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ChangeArmAngle extends CommandBase {

  private Arm m_Arm;
  private PIDController pid;

  private double finalAngle;

  /** Creates a new ChangeArmAngle. */
  public ChangeArmAngle(Arm subsystem, double degree) {

    m_Arm = subsystem;
    pid = new PIDController(m_Arm.getAnglePID()[0], m_Arm.getAnglePID()[1], m_Arm.getAnglePID()[2]);

    finalAngle = degree;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // run the motor at a positive speed to rotate the arm upward, and negative to rotate downward
    // if else in one line
    // pid.calculate(encoder.getDistance(), setpoint)
    m_Arm.setAngleMotorSpeed(pid.calculate(m_Arm.getArmAngle(), finalAngle) * (finalAngle > 0 ? 1 : -1));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Arm.setAngleMotorSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // stop the motor after reaching the desired angle
    // return false;
    return (Math.abs(m_Arm.getArmAngle()) >= Math.abs(finalAngle));
  }
}
