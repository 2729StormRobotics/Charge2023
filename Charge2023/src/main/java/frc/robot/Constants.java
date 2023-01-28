// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

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

    public static final class ArmConstants {
        // need all port nums
        public static final int kExtensionMotorPort = -1;
        public static final int kAngleMotorPort = -1;
        public static final int kStringPotPort = -1;

        public static final double kMaxExtensionLength = 63.75; //inches

        // tbd
        public static final double kAngleMotorSpeed = .5;

        

    }


}