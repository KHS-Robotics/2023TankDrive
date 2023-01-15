package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    VictorSPX leftFront = new VictorSPX(0);
    VictorSPX leftRear = new VictorSPX(1);
    VictorSPX rightFront = new VictorSPX(5);
    VictorSPX rightRear = new VictorSPX(14);
    
    
    public void tankDrive(double left, double right) {
        leftFront.set(VictorSPXControlMode.PercentOutput, left);
        leftRear.set(VictorSPXControlMode.PercentOutput, left);
        rightFront.set(VictorSPXControlMode.PercentOutput, right);
        rightRear.set(VictorSPXControlMode.PercentOutput, right);
    }
    
    
    @Override
    public void periodic() {

    }
    
}
