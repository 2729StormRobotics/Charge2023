// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

        public static final double kMaxExtensionLength = 63.75; // inches

        // tbd
        public static final double kAngleMotorSpeed = .5;
        public static final double kExtensionMotorSpeed = .5;

        // grid constants
        public static final double leftHorizontalShift = 0;
        public static final double midHorizontalShift = 0;
        public static final double rightHorizontalShift = 0;

        public static final double lowAngle = 0;
        public static final double midConeAngle = 0;
        public static final double highConeAngle = 0;
        public static final double midCubeAngle = 0;
        public static final double highCubeAngle = 0;

        public static final double lowExtensionDistance = 0;
        public static final double midExtensionDistance = 0;
        public static final double highExtensionDistance = 0;

        // shelf constants
        public static final double shelfAngle = 0;
        public static final double shelfExtensionDistance = 0;

        // charge station constants
        public static final double chargingAngle = 0;
        public static final double chargingExtensionDistance = 0;

    }

}