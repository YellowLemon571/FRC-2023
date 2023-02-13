package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  private PWMTalonFX motor1 = new PWMTalonFX(4);

  public CommandBase  raiseLift() {
        return this.run(() -> motor1.set(0.5));
    }

  public CommandBase  lowerLift() {
      return this.run(() -> motor1.set(-0.5));
    }

  public CommandBase  stopLift() {
    return this.run(() -> motor1.set(0));
   }
}
