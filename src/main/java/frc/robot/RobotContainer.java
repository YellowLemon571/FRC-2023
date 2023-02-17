package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveRecorder;
import frc.robot.subsystems.Lift;

public class RobotContainer  {
  // The robot's subsystems and commands are defined here...

  public DriveRecorder m_driveRecorder = new DriveRecorder();
  private Lift m_lift = new Lift();
  private Claw m_claw = new Claw();

  public static CommandXboxController driveController = new CommandXboxController(1); 
  public static CommandXboxController attachmentController = new CommandXboxController(0); 

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  public Command getAutonomousCommand() {
    // Placeholder for future use
    return null;
  }

  private void configureButtonBindings() { 
   attachmentController.a().onTrue(m_lift.raiseLift());
   attachmentController.a().onFalse(m_lift.stopLift());

   attachmentController.b().onTrue(m_lift.lowerLift());
   attachmentController.b().onFalse(m_lift.stopLift());

   attachmentController.leftTrigger().onTrue(m_claw.openClaw());
   attachmentController.leftTrigger().onFalse(m_claw.holdClaw());

   attachmentController.rightTrigger().onTrue(m_claw.closeClaw());
   attachmentController.rightTrigger().onFalse(m_claw.holdClaw());

   driveController.povUp().onTrue(m_driveRecorder.startRecord());
   driveController.povDown().onTrue(m_driveRecorder.stopRecord());
  }

}

