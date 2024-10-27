/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/**
 * Default command to drive the robot with a controller.
 */
public class DriveWithController extends Command {

  public DriveWithController() {
    this.addRequirements(RobotContainer.driveTrain);
  }

  @Override
  public void initialize() {
    RobotContainer.driveTrain.setDriveMotors(0, 0);
  }

  @Override
  public void execute() {
    // left stick x-axis controls rotation
    var xInput = RobotContainer.driverController.getLeftX();

    // left trigger is backwards, right trigger is forwards
    var yInput = -RobotContainer.driverController.getLeftTriggerAxis()
        + RobotContainer.driverController.getRightTriggerAxis();

    // calculate left and right from x and y
    var left = MathUtil.clamp(yInput - xInput, -0.40, 0.40);
    var right = MathUtil.clamp(yInput + xInput, -0.40, 0.40);
    RobotContainer.driveTrain.setDriveMotors(left, right);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.driveTrain.setDriveMotors(0, 0);
  }
}
