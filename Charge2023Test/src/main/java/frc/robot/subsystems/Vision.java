// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vision extends SubsystemBase {
  
  private final NetworkTable m_limelightTable;

  private final NetworkTableEntry m_targetDistance;
  private final NetworkTableEntry m_targetDetected;

  private final NetworkTableEntry m_cameraPose;

  private double m_xOffset; // horizontal offset from crosshair to target (-27 degrees to 27 degrees)
  private double m_yOffset; // vertical offset from crosshair to target (-20.5 degrees to 20.5 degrees)
  private double m_percentArea; // target area
  private double m_targetValue; // whether the limelight has an valid targets (0 or 1)

  
  /** Creates a new Vision. */
  public Vision() {

    // Instantiate the network table
    m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    // Initialize the network table entries for target distance and target detected
    m_targetDistance = m_limelightTable.getEntry("Target Distance");
    m_targetDetected = m_limelightTable.getEntry("Target Detected");

    m_cameraPose = m_limelightTable.getEntry("Camera Pose");

    turnOnLED();
  }

  // Returns the horizontal offset to the target 
  public double getXOffset(){
    return m_xOffset;
  }

  // Returns the vertical offset to the target 
  public double getYOffset(){
    return m_yOffset;
  }

  public double getpercentArea(){
    return m_percentArea;
  }

  public double getTargetValue(){
    return m_targetValue;
  }
  
  public boolean isTargetDetected(){
    return (m_targetValue > 0.0);
  }

  public void turnOnLED(){
    m_limelightTable.getEntry("LED Mode").setNumber(3);
  }

  public void turnOffLED(){
    m_limelightTable.getEntry("LED Mode").setNumber(1);
  }

  public void updateLimeLight(){
    m_xOffset = m_limelightTable.getEntry("tx").getDouble(0.0);
    m_yOffset = m_limelightTable.getEntry("ty").getDouble(0.0);
    m_percentArea = m_limelightTable.getEntry("ta").getDouble(0.0);
    m_targetValue = m_limelightTable.getEntry("tv").getDouble(0.0);

    m_targetValue = m_limelightTable.getEntry("t6c_ts").getDouble(0.0);

    m_targetDetected.setBoolean(isTargetDetected());
  }

 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
