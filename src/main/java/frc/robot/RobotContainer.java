package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

//import frc.robot.subsystem.DriveTrain;
import frc.robot.Subsystem.Claw;
import frc.robot.Subsystem.Lift;

public class RobotContainer  {
  // The robot's subsystems and commands are defined here...
  public static CommandXboxController driveController = new CommandXboxController(1); 
  public static CommandXboxController attachmentController = new CommandXboxController(0); 

  private Lift lift = new Lift();
  private Claw claw = new Claw();

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //   configureDriveTrain();
  }

  public Command getAutonomousCommand() {
    // Placeholder for future use
    return null;
  }

  private void configureButtonBindings() { 

    // Consider adding functionality to stop lift/claw motors, constantly-running motors may lead to catastrophe

    attachmentController.a().whileTrue(lift.raiseLift());
    attachmentController.b().whileTrue(lift.lowerLift());
    attachmentController.rightTrigger().whileTrue(claw.closeClaw());
    attachmentController.leftTrigger().whileTrue(claw.openClaw());
  }

}

