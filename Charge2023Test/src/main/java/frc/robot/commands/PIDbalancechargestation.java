// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class PIDbalancechargestation extends CommandBase {
  
  public double power = 0.2;
  private final Drivetrain m_drivetrain;


  //sets the PID values
private static final double kP = 0.01; 
private static final double kI = 0.00; 
private static final double kD = 0.000; 


private final PIDController m_pidController = new PIDController(kP, kI, kD);


  private final double m_angle;
  private static int climbing = 0;

  /** Creates a new upanddowngyro. */
  public PIDbalancechargestation(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    m_angle = m_drivetrain.getRollangle();
  


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.calibrategyro();

   double desiredendangle = -3.7; //angle of gyro at the flat surface
   m_drivetrain.resetGyro();
    
    climbing = 0;
    power = 0;
    m_pidController.setSetpoint(desiredendangle);
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
   double pidOut = m_pidController.calculate(m_drivetrain.getRollangle());

//10 deg = -0.1
//-10 deg = 0.1



   if (pidOut < -.1) pidOut = -.1;
   
   if (pidOut > .1) pidOut = .1;
   
   SmartDashboard.putNumber("Speed for Gyro balance", pidOut);
   
    m_drivetrain.tankDrive(pidOut, pidOut, false);
 
      }


  
    
  
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_drivetrain.stopDrive();
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      
   return false;
  }  
}