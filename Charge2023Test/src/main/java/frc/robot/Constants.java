// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.I2C.Port;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final int kPneumaticsHubCanId = 7;

    public static final class ClawConstants {

        public static final int kLeftRollerMotorPort = 0;
        public static final int kRightRollerMotorPort = 0;
        public static final double kLeftRollerMotorSpeed = 0;
        public static final double kRightRollerMotorSpeed = 0;
        public static final double kRollerMotorStopSpeed = 0;
        public static final double kStopSpeed = 0;

        public static final int kColorSensorPort = 0;
        public static final int kBeamBreakPort = 0;


        public static final int kLeftPistonExtendChannel = 0;
        public static final int kLeftPistonRetractChannel = 0;
        public static final Value kLeftPistonExtendValue = Value.kForward;
        public static final Value kLeftPistonRetractValue = Value.kReverse;

        public static final int kRightPistonExtendChannel = 0;
        public static final int kRightPistonRetractChannel = 0;
        public static final Value kRightPistonExtendValue = Value.kForward;
        public static final Value kRightPistonRetractValue = Value.kReverse;
    }


    public static final class VisionConstants{
        public static final double klimelightHeight = 0;
        public static final double klimelightAngle = 0;

        public static final double kUpperTargetHeight = 104; // 8'8"

        public static final int kdefaultPipeline = 0;
        
        public static final double khorizontalRange = 1.5; // How far off from the crosshair the target can be to be centered on the x-axis

        // Alignment constants for the limelight
        public static final double kAutoAlignP = 0.0;
        public static final double kAutoAlignI = 0.0;
        public static final double kAutoAlignD = 0.0;
        public static final double kAutoAlignTolerance = 1.0;
        public static final double kAutoAlignSpeedTolerance = 1.0;
    }

    public static final class DriveConstants {
        // Get Values For Everything:
        // Drive ports, current limit, gear ratio, feedforward values, pid values (for both), navX Port, 

        // Drive Motor Ports

        public static final int kLeftLeaderMotorPort = 9;
        public static final int kLeftFollowerMotorPort = 6;
        public static final int kRightLeaderMotorPort = 2;
        public static final int kRightFollowerMotorPort = 3;


        // Set If Drive Motors are Reversed
        public static final boolean kLeftLeaderMotorReversedDefault = false;
        public static final boolean kLeftFollowerMotorReversedDefault = false;
        public static final boolean kRightLeaderMotorReversedDefault = true;
        public static final boolean kRightFollowerMotorReversedDefault = true;

        public static final int kCurrentLimit = 0; // NEED TO SET


        // Encoder calculations
        public static final double kDriveWheelDiameterInches = 6.0;
        public static final double kGear = 12; 
        //Testbot Gear ratio- 10.75 : 1
        //Real Robot Gear Ratio- 12 : 1
    
        
        // Calculates the distace per pulse by dividing the circumference by the pulses per revolution
        public static final double kDriveDistancePerRev = Math.PI * kDriveWheelDiameterInches / kGear;
        // Encoders are in RPM so this converts to inches/sec
        public static final double kDriveSpeedPerRev = kDriveDistancePerRev / 60.0; 


        // Drive Distance Feedforward Values
        public static final double kLeftS = 0; // Position
        public static final double kLeftV = 0; // Velocity
        public static final double kLeftA = 0; // Acceleration

        public static final double kRightS = 0;
        public static final double kRightV = 0;
        public static final double kRightA = 0;

        // Drive Distance PID Values
        public static final double kP = 0;
        public static final double kI = 0;
        public static final double kD = 0;

        // Drive Distance Tolerance and Maximums in inches and seconds
        public static final double kPositionTolerance = 1.0; // Placeholder
        public static final double kVelocityTolerance = 5.0; //Placeholder


        //NavX Port
        public static final int kNavXPort = 0; 

        //Point Turn PID Values
        public static final double kTurnP = .005;
        public static final double kTurnI = 0;
        public static final double kTurnD = 0;

        //Point Turn Tolerances in degrees and seconds
        public static final double kAngleTolerance = 1.0; //Placeholder
        public static final double kTurnSpeedTolerance = 1.0; //Placeholder

        public static final double kTurnAngleToInches = (22.75 * Math.PI) / 360;


        // Driver Controller Ports
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;

        public static final double kTurnSpeed = .25;

    }
    
    public static final class ButtonBindingConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
    }

    public static final class ArmConstants {

        // port numbers
        public static final int kExtensionMotorPort = 9;
        public static final int kAngleMotorPort = 8;
        public static final int kAngleMotorFollowerPort = 2;
        public static final int kLimitSwitchPort = -1;

        // Arm Angle Tolerance
        public static final double kArmAngleTolerance = .1;

        public static final double kArmLength = 34.5; // inches
        // tbd
        public static final double kAngleMaxMotorSpeed = .1;
        // grid constants
        public static final double kLowAngle = 0;
        public static final double kMidConeAngle = 0;
        public static final double kMidCubeAngle = 0;
        public static final double kShelfAngle = 0;
        // charge station constants
        public static final double kChargingAngle = 0;
        // angle motor pid
        public static final double kP = 0.00425;
        public static final double kI = 0;
        public static final double kD = 0;

    }


}
