package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class DriveWithController extends CommandBase {

    public DriveWithController() {
        addRequirements(RobotContainer.driveTrain);
    }
    
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        RobotContainer.driveTrain.tankDrive(RobotContainer.m_driverController.getLeftY(), RobotContainer.m_driverController.getRightY());
    }

    @Override
    public void end(boolean interrupted) {

    }
}
