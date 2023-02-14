// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import static frc.robot.Constants.ArmConstants.*;

public class TelescopeToDistance extends CommandBase {

  private Arm m_Arm;

  private double distance;

  /** Creates a new TelescopeToDistance. */
  public TelescopeToDistance(Arm subsystem, double dist) {

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
    // if extend is true, run the motor at a positive speed to extend the arm
    // if extend is false, run the motor at a negative speed to retract the arm
    m_Arm.setAngleMotorSpeed((distance > m_Arm.getExtendedDistance() ? kAngleMotorSpeed : -kAngleMotorSpeed));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_Arm.setAngleMotorSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // stop this command when the arm is fully extended or fully retracted or when the target distance is reached
    
    if (m_Arm.getExtendedDistance() >= kMaxExtensionLength) {
      return false;
    } else if (m_Arm.getExtendedDistance() <= 0) {
      return false;
    } else if (m_Arm.getExtendedDistance() >= distance) {
      return false;
    }
    
    return true;

  }

}
