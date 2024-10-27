/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
  // HIDs
  public static final int kDriveControllerPort = 0;

  // Drive Train
  public static final int kLeftFrontDriveMotor = 8;
  public static final int kLeftRearDriveMotor = 6;
  public static final int kRightFrontDriveMotor = 7;
  public static final int kRightRearDriveMotor = 5;
}
