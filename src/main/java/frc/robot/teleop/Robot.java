// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.teleop;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;  
  private Command m_autonomousCommand;

  public static final int kFrontLeftChannel = 2;
  public static final int kRearLeftChannel = 3;
  public static final int kFrontRightChannel = 1;
  public static final int kRearRightChannel = 0;

  public static boolean movement;
  //public static double multiplier;

  public MecanumDrive m_robotDrive;
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    VictorSP frontLeft = new VictorSP(kFrontLeftChannel);
    VictorSP rearLeft = new VictorSP(kRearLeftChannel);
    VictorSP frontRight = new VictorSP(kFrontRightChannel);
    VictorSP rearRight = new VictorSP(kRearRightChannel);

    // Invert the right side motors.
    // You may need to change or remove this to match your robot.
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
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
public void autonomousPeriodic() {
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
    if (movement) { // Needed for recording playback

      double multiplier;
      if (RobotContainer.driveController.leftBumper().getAsBoolean()) {
        multiplier = 1.0;
      } else if (RobotContainer.driveController.rightBumper().getAsBoolean()) {
        multiplier = 0.25;
      } else {
        multiplier = 0.5;
      }

      m_robotDrive.driveCartesian(-RobotContainer.driveController.getLeftY() * multiplier, RobotContainer.driveController.getLeftX() * multiplier, RobotContainer.driveController.getRightX() * multiplier);
    }
  }

  public Object set(double d) {
    return null;
  }

  public void setTargetPosition(int targetCount) {
  }

public boolean isBusy() {
    return true;
}
}
