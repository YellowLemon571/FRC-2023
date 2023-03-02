package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

//for command functions
import edu.wpi.first.wpilibj2.command.CommandBase;

//allows for "run" commands
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  //says what port the motor is plugged into
  private PWMTalonFX rightLift = new PWMTalonFX(4);
  private PWMTalonFX leftLift = new PWMTalonFX(5);
  
  MotorControllerGroup Lift = new MotorControllerGroup(leftLift, rightLift);
 
  public CommandBase  raiseLift() {
        return this.run(() -> Lift.set(-0.25));
    }

  public CommandBase  lowerLift() {
      return this.run(() -> Lift.set(0.25));
    }

  public CommandBase  stopLift() {
    return this.run(() -> Lift.set(0));
   }

}
