package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    VictorSPX leftFront = new VictorSPX(8);
    VictorSPX leftRear = new VictorSPX(6);
    VictorSPX rightFront = new VictorSPX(7);
    VictorSPX rightRear = new VictorSPX(5);


    public void tankDriveTwoSticks(double left, double right) {
          leftFront.set(VictorSPXControlMode.PercentOutput, -left);
          leftRear.set(VictorSPXControlMode.PercentOutput, -left);
          rightFront.set(VictorSPXControlMode.PercentOutput, right);
          rightRear.set(VictorSPXControlMode.PercentOutput, right);
    }

    public void tankDriveOneStick(double x, double y) {
        tankDriveTwoSticks(y + x, y - x);
    }

    @Override
    public void periodic() {
        
    }
}
