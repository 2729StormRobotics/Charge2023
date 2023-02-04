// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ArmConstants.*;

public class Arm extends SubsystemBase {

  private CANSparkMax extensionMotor;
  private RelativeEncoder extensionEncoder;
  private CANSparkMax angleMotor;
  private CANSparkMax follow;
  // private AnalogPotentiometer stringPot;
  private RelativeEncoder angleEncoder;

  /** Creates a new Arm 💪 */
  public Arm() {

    extensionMotor = new CANSparkMax(kExtensionMotorPort, MotorType.kBrushless);
    extensionEncoder = extensionMotor.getEncoder();

    angleMotor = new CANSparkMax(kAngleMotorPort, MotorType.kBrushless);
    angleEncoder = angleMotor.getEncoder();

    follow = new CANSparkMax(2, MotorType.kBrushless);
    follow.follow(angleMotor);

    // AnalogInput input = new AnalogInput(kStringPotPort);

    // input, full range of motion, starting position
    // stringPot = new AnalogPotentiometer(input, kMaxExtensionLength, 0);

    resetEncoders();

  }
  
  public void setExtensionMotorSpeed(double speed) {
    // run the motor that extends the arm
    extensionMotor.set(speed);
  }

  public void setAngleMotorSpeed(double speed) {
    // run the motor that changes the angle of the arm
    angleMotor.set(speed);
  }

  // public double getStringPotDistance() {
  //   // get the voltage read by the string potientometer in terms of distance
  //   return stringPot.get();
  // }

  public double getArmAngle() {
    // * 360 to change rotations into degrees
    // % 360 to change keep angles within 0-360 degrees
    return angleEncoder.getPosition() / 18.812238693237305 * 360 % 360;
  }

  public double getExtendedDistance() {
    // convert encoder reading to inches extended on the arm
    return extensionEncoder.getPosition() / kMaxExtensionLengthInEncoderTicks * kMaxExtensionLength;
  }

  public void resetEncoders() {
    // reset the angleMotor's encoder
    angleEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm Angle (deg)", getArmAngle());
    // SmartDashboard.putNumber("String Pot Distance", getStringPotDistance());
    SmartDashboard.putNumber("Distance Extended (in)", getExtendedDistance());

  }
}