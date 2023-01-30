package frc.robot;

//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

//import frc.robot.subsystem.DriveTrain;
import frc.robot.Subsystem.claw;
import frc.robot.Subsystem.Lift;

public class RobotContainer  {
// The robot's subsystems and commands are defined here...
CommandXboxController DriveController = new CommandXboxController(1); 
CommandXboxController AttachmentController = new CommandXboxController(0); 

//private DriveTrain drivetrain = new DriveTrain();
private Lift lift = new Lift();
private claw Claw = new claw();

public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
 //   configureDriveTrain();
  }

private void configureButtonBindings() { 
  AttachmentController.a().whileTrue(lift.raiseLift());
  AttachmentController.b().whileTrue(lift.lowerLift());
  AttachmentController.rightTrigger().whileTrue(Claw.closeClaw());
  AttachmentController.leftTrigger().whileTrue(Claw.openClaw());

  if DriveController.leftBumper().whileTrue(
    m_robotDrive.driveCartesian(-m_stick.getY() * 0.5, -m_stick.getX() * 0.5, -m_stick.getZ() * 0.5);){
  } else if DriveController.rightBumper().whileTrue(
    m_robotDrive.driveCartesian(-m_stick.getY() , -m_stick.getX(), -m_stick.getZ());) {
  } else m_robotDrive.driveCartesian(-m_stick.getY() * 0.8, -m_stick.getX() * 0.8, -m_stick.getZ() * 0.8); {
  }

  }

}


//Trigger and Button methods were renamed to be consistent and Button class deprecated.
//Trigger’s bindings are changed to use True/False terminology, as it should be unambiguous. Each binding type has both True and False variants; for brevity, only the True variants are listed here:
//onTrue (replaces whenActive and whenPressed): schedule on rising edge.
//whileTrue (replaces whileActiveOnce): schedule on rising edge, cancel on falling edge.
//toggleOnTrue (replaces toggleWhenActive): on rising edge, schedule if unscheduled and cancel if scheduled.

