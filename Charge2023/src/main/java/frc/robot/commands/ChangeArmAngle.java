// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import static frc.robot.Constants.ArmConstants.*;

public class ChangeArmAngle extends CommandBase {

  private Arm m_Arm;

  private double initialAngle;
  private double finalAngle;

  /** Creates a new changeArmAngle. */
  public ChangeArmAngle(Arm subsystem, double degree) {

    m_Arm = subsystem;

    initialAngle = 0;
    finalAngle = degree;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // get the initial angle of the robot
    initialAngle = m_Arm.getArmAngle();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // run the motor at a positive speed to rotate the arm upward, and negative to rotate downward
    // if else in one line
    m_Arm.setAngleMotorSpeed(kAngleMotorSpeed * (finalAngle > 0 ? 1 : -1));

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
    return (Math.abs(m_Arm.getArmAngle() - initialAngle) >= Math.abs(finalAngle));
  }
}
