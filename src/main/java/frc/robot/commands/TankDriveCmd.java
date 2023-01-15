package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TankDriveCmd extends CommandBase {
    public TankDriveCmd() {
        addRequirements(RobotContainer.dt);
    }
    
    
    
    @Override
    public void initialize() {

    }

    @Override 
    public void execute() {
        RobotContainer.dt.tankDrive(RobotContainer.m_driverController.getLeftY(), RobotContainer.m_driverController.getRightY());
    }

    @Override
    public void end(boolean interrupted) {


    }
}
