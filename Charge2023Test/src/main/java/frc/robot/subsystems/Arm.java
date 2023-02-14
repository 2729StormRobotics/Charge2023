// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ArmConstants.*;

import java.util.Arrays;

public class Arm extends SubsystemBase {
  
  private CANSparkMax angleMotor;
  private CANSparkMax angleMotorFollower;
  private RelativeEncoder angleEncoder;
  private DigitalInput limitSwitch;

  private double[] angleMotorPID;


  /** Creates a new Arm 💪 */
  public Arm() {

    angleMotor = new CANSparkMax(kAngleMotorPort, MotorType.kBrushless);
    angleEncoder = angleMotor.getEncoder();

    angleMotorFollower = new CANSparkMax(kAngleMotorFollowerPort, MotorType.kBrushless);
    angleMotorFollower.follow(angleMotor);

    angleMotorPID = new double[]{kP,kI,kD};

    limitSwitch = new DigitalInput(kLimitSwitchPort);

    resetEncoders();
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
    return Math.abs(angleEncoder.getPosition()) / kEncoderTicksPerRevolution * 360 % 360;
  }

  public double[] getAnglePID() {
    return angleMotorPID;
  }

  public boolean getLimitSwitch() {
    return !limitSwitch.get();
  }

  public void resetEncoders() {
    // reset the angleMotor's encoder
    angleEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // set the arm's angle to 0 when we hit the limit switch

    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm Angle (deg)", getArmAngle());

    // angleMotorPID[0] = SmartDashboard.getNumber("Arm Angle P", 0.0);
    // angleMotorPID[1] = SmartDashboard.getNumber("Arm Angle I", 0.0);
    // angleMotorPID[2] = SmartDashboard.getNumber("Arm Angle D", 0.0);

    // SmartDashboard.putString("Angle PID In Use", Arrays.toString(angleMotorPID));


  }
}