/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class TankDrive extends SubsystemBase {
  private final VictorSPX leftFront = new VictorSPX(RobotMap.kLeftFrontDriveMotor);
  private final VictorSPX leftRear = new VictorSPX(RobotMap.kLeftRearDriveMotor);
  private final VictorSPX rightFront = new VictorSPX(RobotMap.kRightFrontDriveMotor);
  private final VictorSPX rightRear = new VictorSPX(RobotMap.kRightRearDriveMotor);

  /**
   * Tank drive control for one joystick.
   * 
   * @param x the x-input of the joystick
   * @param y the y-input of the joystick
   */
  public void controlWithOneStick(double x, double y) {
    var left = y + x;
    var right = y - x;
    this.setDriveMotors(left, right);
  }

  /**
   * Directly set the left and right outputs.
   * 
   * @param leftInput  the left value
   * @param rightInput the right value
   */
  public void setDriveMotors(double leftInput, double rightInput) {
    var leftOutput = normalizeMotorOutput(leftInput);
    var rightOutput = normalizeMotorOutput(rightInput);

    leftFront.set(VictorSPXControlMode.PercentOutput, -leftOutput);
    leftRear.set(VictorSPXControlMode.PercentOutput, -leftOutput);
    rightFront.set(VictorSPXControlMode.PercentOutput, rightOutput);
    rightRear.set(VictorSPXControlMode.PercentOutput, rightOutput);
  }

  /**
   * Clamps the given value to between -1 and 1.
   * 
   * @param value the value to clamp
   * @return the value clamped from -1 to 1
   */
  private double normalizeMotorOutput(double value) {
    return MathUtil.clamp(value, -1, 1);
  }

  @Override
  public void periodic() {
  }
}
