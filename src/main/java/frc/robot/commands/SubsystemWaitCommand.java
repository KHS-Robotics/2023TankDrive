package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class SubsystemWaitCommand extends CommandBase {
    private Timer timer = new Timer();
    private double time;
    public SubsystemWaitCommand (double time,Subsystem... systems) {
        addRequirements(systems);
        this.time = time;
    }
    
    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(time);
    }
}
