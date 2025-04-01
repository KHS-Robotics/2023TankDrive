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
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotMap;

/**
 * Tank Drive subsystem.
 */
public class TankDrive extends SubsystemBase {
  private final VictorSPX leftFront;
  private final VictorSPX leftRear;
  private final VictorSPX rightFront;
  private final VictorSPX rightRear;

  /**
   * Create the Tank Drive.
   */
  public TankDrive() {
    leftFront = new VictorSPX(RobotMap.kLeftFrontDriveMotor);
    leftRear = new VictorSPX(RobotMap.kLeftRearDriveMotor);
    rightFront = new VictorSPX(RobotMap.kRightFrontDriveMotor);
    rightRear = new VictorSPX(RobotMap.kRightRearDriveMotor);
  }

  /** {@inheritDoc}} */
  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);

  }

  /** {@inheritDoc}} */
  @Override
  public void periodic() {
  }

  /**
   * Command to control the tank drive with an Xbox controller.
   * 
   * @param hid the xbox controller
   * @return the command to control the tank drive with an Xbox controller
   */
  public Command controlWithXboxController(CommandXboxController hid, double maxPercentSpeed) {
    var cmd = runEnd(() -> {
      // left stick x-axis controls rotation
      var xInput = hid.getLeftX();

      // left trigger is backwards, right trigger is forwards
      var yInput = -hid.getLeftTriggerAxis() + hid.getRightTriggerAxis();

      // calculate left and right from x and y
      var left = MathUtil.clamp(yInput - xInput, -maxPercentSpeed, maxPercentSpeed);
      var right = MathUtil.clamp(yInput + xInput, -maxPercentSpeed, maxPercentSpeed);

      setDriveMotors(left, right);
    }, this::stop);

    return cmd.withName("DriveTankWithXbox");
  }

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
   * Command to stops the tank drive motors.
   * 
   * @return the command to stop the tank drive motors
   */
  public Command stopCommand() {
    var cmd = runOnce(this::stop);
    return cmd.withName("StopTankDrive");
  }

  /**
   * Stops the tank drive motors.
   */
  public void stop() {
    leftFront.set(VictorSPXControlMode.PercentOutput, 0);
    leftRear.set(VictorSPXControlMode.PercentOutput, 0);
    rightFront.set(VictorSPXControlMode.PercentOutput, 0);
    rightRear.set(VictorSPXControlMode.PercentOutput, 0);
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
}
