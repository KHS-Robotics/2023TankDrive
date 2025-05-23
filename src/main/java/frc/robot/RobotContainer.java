// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. 
 * 
 * Since Command-based is a "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot} periodic methods (other than the scheduler calls). 
 * 
 * Instead, the structure of the robot (including subsystems, commands, and trigger mappings) 
 * should be declared here.
 */
public final class RobotContainer {
  // Driver Station HIDs
  public static final CommandXboxController driverController = new CommandXboxController(RobotMap.kDriveControllerPort);

  // Robot Subsystems
  public static final TankDrive driveTrain = new TankDrive();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    this.configureDefaultCommands();
    this.configureBindings();

    SmartDashboard.putData(CommandScheduler.getInstance());
  }

  /** Sets the default commands for robot subsystems. */
  private void configureDefaultCommands() {
    driveTrain.setDefaultCommand(driveTrain.controlWithXboxController(driverController, Constants.kMaxTankDriveOutputPercent));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
  }
}
