package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase{
  private PWMTalonFX LeftClaw = new PWMTalonFX(5);
  private PWMTalonFX RightClaw = new PWMTalonFX(6);

  public final MotorControllerGroup claw =
        new MotorControllerGroup(LeftClaw, RightClaw);

public Claw(){
  RightClaw.setInverted(true);
}
  public CommandBase openClaw(){
    return this.run(()  -> claw.set(0.5));
  }

  public CommandBase closeClaw(){
    return this.run(()  -> claw.set(-0.5));
  }

  public CommandBase holdClaw(){
    return this.run(()  -> claw.set(0));
  }
}
