// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;

  private Command m_autonomousCommand;

  private static final int kFrontLeftChannel = 2;
  private static final int kRearLeftChannel = 3;
  private static final int kFrontRightChannel = 1;
  private static final int kRearRightChannel = 0;

  public static boolean movement;
  //public static double xSpeed, ySpeed, zRotation, multiplier;
  public static double multiplier;

  public MecanumDrive m_robotDrive;
  private Joystick m_stick;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    PWMSparkMax frontLeft = new PWMSparkMax(kFrontLeftChannel);
    PWMSparkMax rearLeft = new PWMSparkMax(kRearLeftChannel);
    PWMSparkMax frontRight = new PWMSparkMax(kFrontRightChannel);
    PWMSparkMax rearRight = new PWMSparkMax(kRearRightChannel);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

    m_stick = new Joystick(1);
  }
  
@Override
public void robotPeriodic() {
  CommandScheduler.getInstance().run();

  if (RobotContainer.driveController.start().getAsBoolean() && RobotContainer.driveController.a().getAsBoolean()) {
    CommandXboxController temp = RobotContainer.attachmentController;
    RobotContainer.attachmentController = RobotContainer.driveController;
    RobotContainer.driveController = temp;
  } else if (RobotContainer.attachmentController.start().getAsBoolean() && RobotContainer.attachmentController.b().getAsBoolean()) {
    CommandXboxController temp = RobotContainer.driveController;
    RobotContainer.driveController = RobotContainer.attachmentController;
    RobotContainer.attachmentController = temp;
  }
}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void teleopInit() {
    movement = true;
  }

  @Override
  public void teleopPeriodic() {
    // Use the joystick X axis for forward movement, Y axis for lateral
    // movement, and Z axis for rotation.

    // Speed switching needs to be performed here as whileTrue() does not cover two bumpers being false at the same time

    if (movement) { // Needed for recording playback
     // xSpeed = RobotContainer.driveController.getLeftY();
     // ySpeed = RobotContainer.driveController.getLeftX();
     // zRotation = RobotContainer.driveController.getRightX();

      if (RobotContainer.driveController.leftBumper().getAsBoolean()) {
        multiplier = 1.0;
      } else if (RobotContainer.driveController.rightBumper().getAsBoolean()) {
        multiplier = 0.25;
      } else {
        multiplier = 0.5;
      }

      m_robotDrive.driveCartesian(-m_stick.getY(), -m_stick.getX(), -m_stick.getZ());
    }
  }
}
