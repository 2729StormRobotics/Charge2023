// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class PIDarcadepointturn extends CommandBase {
  /** Creates a new PIDarcadepointturn. */

  private final Drivetrain m_drivetrain;


  //sets the PID values
private static final double kP = 0.02; 
private static final double kI = 0.00; 
private static final double kD = 0.000; 


private final PIDController m_pidController = new PIDController(kP, kI, kD);


  private final double m_angle;
  private static int climbing = 0;
  

public PIDarcadepointturn(Drivetrain drivetrain, double angletoget) {
  m_drivetrain = drivetrain;
  m_angle = m_drivetrain.getRobotAngle();
  
    m_pidController.setSetpoint(angletoget);

    addRequirements(m_drivetrain);
   // m_drivetrain.resetGyro();
    m_drivetrain.calibrategyro();
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetGyro();
 //   m_drivetrain.calibrategyro();
    m_pidController.setTolerance(1);
    
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double pid = m_pidController.calculate(m_drivetrain.getRobotAngle());
    
    
    
    if (pid < -.2) pid = -.2;
    
    if (pid > .2) pid = .2;
    
    SmartDashboard.putNumber("Speed for point turn", pid);
    m_drivetrain.tankDrive(-pid, pid, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
