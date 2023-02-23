// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.teleop;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;  
  private Command m_autonomousCommand;


  //public static double multiplier;

  public MecanumDrive m_robotDrive;
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }
  
@Override
public void robotPeriodic() {
  CommandScheduler.getInstance().run();

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
  }

  @Override
  public void teleopPeriodic() {
   
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
