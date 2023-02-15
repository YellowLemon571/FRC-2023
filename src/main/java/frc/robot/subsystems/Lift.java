package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  private PWMTalonFX Lift = new PWMTalonFX(4);

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
