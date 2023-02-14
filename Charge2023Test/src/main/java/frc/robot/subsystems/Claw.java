// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */

  public Claw() {
    m_leftRollerMotor = new CANSparkMax(kLeftRollerMotorPort,MotorType.kBrushless);
    m_rightRollerMotor = new CANSparkMax(kRightRollerMotorPort,MotorType.kBrushless);
    m_clawBeamBreak = new DigitalInput(kBeamBreakPort);
    m_leftPiston = new DoubleSolenoid(kPneumaticsHubCanId,PneumaticsModuleType.REVPH, kLeftPistonExtendChannel, kLeftPistonRetractChannel);
    m_rightPiston = new DoubleSolenoid(kPneumaticsHubCanId,PneumaticsModuleType.REVPH, kRightPistonExtendChannel, kRightPistonRetractChannel);
 // m_colorsensor = new ColorSensorV3(kColorSensorPort);

  }
  //initiates the roller motors to pick up game piece
public void runRollerMotors(double speed) {
  m_leftRollerMotor.set(speed);
  m_rightRollerMotor.set(speed);
}

public boolean hasPiece() {
  return !m_clawBeamBreak.get();
}

//measures the motor current while the motors are running, once the current has spiked certain value (kCurrent) then we know we have a game piece
public boolean hasPieceV2() {
  return !(m_rightRollerMotor.getOutputCurrent() > kCurrent);
}

//talk with DAF and see if we are using beambreak on claw or not. If not, we use hasPieceV2

 //stops both motors
 public void stopRollerMotors(double kRollerMotorStopSpeed) {
  if (hasPieceV2()== true) {
    m_leftRollerMotor.set(kRollerMotorStopSpeed);
    m_rightRollerMotor.set(kRollerMotorStopSpeed);
  } 


}

public void haltMotors(double kRollerMotorStopSpeed) {

    m_leftRollerMotor.set(0);
    m_rightRollerMotor.set(0);
}

//reverses the roller motors to eject game piece
public void ejectRollerMotors(double kshootSpeed) {
  m_leftRollerMotor.set(kshootSpeed);
  m_rightRollerMotor.set(kshootSpeed);
}

public void extendRightPiston() {
m_rightPiston.set(kRightPistonExtendValue);
}

public void retractRightPiston() {
  m_rightPiston.set(kRightPistonRetractValue);
}

public void extendLeftPiston () {
  m_leftPiston.set(kLeftPistonExtendValue);
  }

  public void retractLeftPiston() {
    m_leftPiston.set(kLeftPistonRetractValue);
  }


  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Have Game Piece", hasPieceV2());
    SmartDashboard.putNumber("Roller Current Output", m_rightRollerMotor.getOutputCurrent());


  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
