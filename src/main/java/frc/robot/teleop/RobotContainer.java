package frc.robot.teleop;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
//import frc.robot.commands.Record;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DriveRecorder;
import frc.robot.subsystems.Lift;
import frc.robot.util.liftUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotContainer  {
  // The robot's subsystems and commands are defined here...

  public static DriveRecorder m_driveRecorder = new DriveRecorder();

  public static CommandXboxController driveController = new CommandXboxController(1); 
  public static CommandXboxController attachmentController = new CommandXboxController(0); 

 private Lift lift = new Lift();
  private Claw claw = new Claw();
  private DriveRecorder record = new DriveRecorder();

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
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
protected void execute() {
  SmartDashboard.putNumber("Lift position", liftUtil.getEncoderCount);
}
}

