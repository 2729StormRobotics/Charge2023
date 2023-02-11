// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.DriveDistance.*;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class upanddowngyro extends CommandBase {
  
  public double power = 0.2;
  private final Drivetrain m_drivetrain;

  private final double m_speed;

  private final double m_angle;
  private static int climbing = 0;

  /** Creates a new upanddowngyro. */
  public upanddowngyro(double speed, double rollangle, Drivetrain drivetrain) {
    m_speed = speed;
    m_drivetrain = drivetrain;
    m_angle = m_drivetrain.getRollangle();
  


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.calibrategyro();
    m_drivetrain.resetGyro();
    climbing = 0;
    power = 0;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.tankDrive(power, power, false);
   
    if (climbing == 0) {
      power = 0.2;
        if (m_drivetrain.getRollangle() < -11) {
       
          climbing = 1; 
          power = 0.1;
      }
    }
    if (climbing == 1 && m_drivetrain.getRollangle() > 0) {
      climbing = 2;
      power = -.07;
    }
    // if (climbing == 2 && m_drivetrain.getRollangle() >= 0) {
    //   climbing = 3;
    //   power = -.07;
    // }
    if (climbing == 2 && Math.abs(m_drivetrain.getRollangle()) >= 2.5) {
      climbing = 3;
      power = .07;
    }

    if (climbing == 3 && Math.abs(m_drivetrain.getRollangle()) <= 2.5) {
       climbing = 4;
       power = 0;
     }

    // if (climbing >= 2) {

    //     power = -.05;
      }


  
    
  
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      m_drivetrain.stopDrive();
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      
   

  if (climbing == 5 && Math.abs(m_drivetrain.getRollangle()) <= 2.5) {
      return true; 
  } else { 
        return false;
  }
  }  
}

   


