package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase{
  private PWMTalonFX claw = new PWMTalonFX(5);

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
