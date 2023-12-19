package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveWithController extends CommandBase {

    public DriveWithController() {
        addRequirements(RobotContainer.driveTrain);
    }
    
    @Override
    public void initialize() {
        System.out.println("Drive with controller");
    }

    @Override
    public void execute() {
        // left stick x-axis controls rotation
        var xInput = RobotContainer.m_driverController.getLeftX();

        // left trigger is backwards, right trigger is forwards
        var yInput = -RobotContainer.m_driverController.getLeftTriggerAxis() + RobotContainer.m_driverController.getRightTriggerAxis();

        // calculate left and right from x and y
        var left = MathUtil.clamp(yInput - xInput, -0.40, 0.40);
        var right = MathUtil.clamp(yInput + xInput, -0.40, 0.40);
        RobotContainer.driveTrain.tankDriveTwoSticks(left, right);
        System.out.println("Inside drive with controller");
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.driveTrain.tankDriveTwoSticks(0, 0);
    }
}
