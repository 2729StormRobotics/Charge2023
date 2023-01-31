// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ArmConstants.*;

public class Arm extends SubsystemBase {

  private CANSparkMax extensionMotor;
  private CANSparkMax angleMotor;
  private AnalogPotentiometer stringPot;
  private RelativeEncoder angleEncoder;

  /** Creates a new Arm. */
  public Arm() {

    extensionMotor = new CANSparkMax(kExtensionMotorPort, MotorType.kBrushless);
    angleMotor = new CANSparkMax(kAngleMotorPort, MotorType.kBrushless);
    angleEncoder = angleMotor.getEncoder();

    AnalogInput input = new AnalogInput(kStringPotPort);

    // input, full range of motion, starting position
    stringPot = new AnalogPotentiometer(input, kMaxExtensionLength, 0);

    resetEncoders();

  }

  public void setExtensionMotorSpeed(double speed) {

    extensionMotor.set(speed);

  }

  public void setAngleMotorSpeed(double speed) {

    angleMotor.set(speed);

  }

  public double getStringPotDistance() {

    return stringPot.get();

  }

  public double getArmAngle() {
    // * 360 to change rotations into degrees
    // % 360 to change keep angles within 0-360 degrees
    return angleEncoder.getPosition() * 360 % 360;
  }

  public void resetEncoders() {
    angleEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}