// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {

  private final NetworkTable m_limelightTable;

  private double m_xOffset; // horizontal offset from crosshair to target (-27 degrees to 27 degrees)
  private double m_yOffset; // vertical offset from crosshair to target (-20.5 degrees to 20.5 degrees)

  /** Creates a new Vision. */
  public Vision() {

    m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

  }

  // Returns the horizontal offset to the target
  public double getXOffset() {
    return m_xOffset;
  }

  // Returns the vertical offset to the target
  public double getYOffset() {
    return m_yOffset;
  }

  public void updateLimelight() {
    m_xOffset = m_limelightTable.getEntry("tx").getDouble(0.0); // Key and defaultvalue cannot be removed, vscode doesn't allow it -\( '-' )/-
    m_yOffset = m_limelightTable.getEntry("ty").getDouble(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
