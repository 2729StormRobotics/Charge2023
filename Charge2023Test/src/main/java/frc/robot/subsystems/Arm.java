// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ArmConstants.*;

import java.util.Arrays;

public class Arm extends SubsystemBase {
  
  private CANSparkMax angleMotor;
  private CANSparkMax follow;
  private RelativeEncoder angleEncoder;

  private double[] angleMotorPID;


  /** Creates a new Arm 💪 */
  public Arm() {

   

    angleMotor = new CANSparkMax(kAngleMotorPort, MotorType.kBrushless);
    angleEncoder = angleMotor.getEncoder();

    follow = new CANSparkMax(2, MotorType.kBrushless);
    follow.follow(angleMotor);

    angleMotorPID = new double[]{0.00425,0.0,0.0}; 

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
    return Math.abs(angleEncoder.getPosition()) / 18.43824577331543 * 360 % 360;
  }

  public double[] getAnglePID() {
    return angleMotorPID;
  }

  public void resetEncoders() {
    // reset the angleMotor's encoder
    angleEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm Angle (deg)", getArmAngle());

    // angleMotorPID[0] = SmartDashboard.getNumber("Arm Angle P", 0.0);
    // angleMotorPID[1] = SmartDashboard.getNumber("Arm Angle I", 0.0);
    // angleMotorPID[2] = SmartDashboard.getNumber("Arm Angle D", 0.0);

    SmartDashboard.putString("Angle PID In Use", Arrays.toString(angleMotorPID));


  }
}