package frc.robot.Subsystem;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
/* import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX; */
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Lift extends SubsystemBase {
  private PWMTalonFX motor1 = new PWMTalonFX(4);

  public CommandBase  raiseLift() {
        return this.run(() -> motor1.set(1));
    }

    public CommandBase  lowerLift() {
      return this.run(() -> motor1.set(-1));
  }
}
