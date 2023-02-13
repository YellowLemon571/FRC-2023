package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.Record;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveRecorder;
import frc.robot.subsystems.Lift;

public class RobotContainer  {
  // The robot's subsystems and commands are defined here...

  public static DriveRecorder m_driveRecorder = new DriveRecorder();

  public static CommandXboxController driveController = new CommandXboxController(1); 
  public static CommandXboxController attachmentController = new CommandXboxController(0); 

  private Lift lift = new Lift();
  private Claw claw = new Claw();

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  public Command getAutonomousCommand() {
    // Placeholder for future use
    return null;
  }

  private void configureButtonBindings() { 

    if (RobotContainer.attachmentController.a().getAsBoolean()){
      lift.raiseLift();
    } else {
      lift.stopLift();
    }

    if (RobotContainer.attachmentController.b().getAsBoolean()){
      lift.lowerLift();
    } else {
      lift.stopLift();
    }

    if (RobotContainer.attachmentController.rightTrigger().getAsBoolean()){
      claw.closeClaw();
    } else {
      claw.holdClaw();
    }

    if (RobotContainer.attachmentController.leftTrigger().getAsBoolean()){
      claw.openClaw();
    } else {
      claw.holdClaw();
    }
    
    driveController.povUp().onTrue(new Record(true));
    driveController.povDown().onTrue(new Record(false));
  }

}

