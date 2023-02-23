package frc.robot.teleop;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.*;

public class RobotContainer  {
  // The robot's subsystems and commands are defined here...

  public static DriveRecorder m_driveRecorder = new DriveRecorder();

  public static CommandXboxController driveController = new CommandXboxController(1); 
  public static CommandXboxController attachmentController = new CommandXboxController(0); 

 private Lift lift = new Lift();
  private Claw claw = new Claw();
  private DriveSystem m_robotDrive;
  private DriveRecorder record = new DriveRecorder();
  private boolean movement;

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureDrivetrainBindings();
  }

  public Command getAutonomousCommand() {
    // Placeholder for future use
    return null;
  }

  private void configureButtonBindings() { 
    attachmentController.a().onTrue(lift.raiseLift());
    attachmentController.a().onFalse(lift.stopLift());

    attachmentController.b().onTrue(lift.lowerLift());
    attachmentController.b().onFalse(lift.stopLift());

   attachmentController.leftTrigger().onTrue(claw.openClaw());
   attachmentController.leftTrigger().onFalse(claw.holdClaw());

   attachmentController.rightTrigger().onTrue(claw.closeClaw());
   attachmentController.rightTrigger().onFalse(claw.holdClaw());

   driveController.povUp().onTrue(record.startRecord());
   driveController.povDown().onTrue(record.stopRecord());
  }

  private void configureDrivetrainBindings(){
    if (RobotContainer.driveController.start().getAsBoolean() && RobotContainer.driveController.a().getAsBoolean()) {
      CommandXboxController temp = RobotContainer.attachmentController;
      RobotContainer.attachmentController = RobotContainer.driveController;
      RobotContainer.driveController = temp;
    } else if (RobotContainer.attachmentController.start().getAsBoolean() && RobotContainer.attachmentController.b().getAsBoolean()) {
      CommandXboxController temp = RobotContainer.driveController;
      RobotContainer.driveController = RobotContainer.attachmentController;
      RobotContainer.attachmentController = temp;
    }

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
}

