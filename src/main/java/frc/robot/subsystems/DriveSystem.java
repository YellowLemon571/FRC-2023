package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class DriveSystem {
    public static final int kFrontLeftChannel = 2;
    public static final int kRearLeftChannel = 3;
    public static final int kFrontRightChannel = 1;
    public static final int kRearRightChannel = 0;
    public static boolean movement;

    
    VictorSP frontLeft = new VictorSP(kFrontLeftChannel);
    VictorSP rearLeft = new VictorSP(kRearLeftChannel);
    VictorSP frontRight = new VictorSP(kFrontRightChannel);
    VictorSP rearRight = new VictorSP(kRearRightChannel);

    public final MecanumDrive m_robotDrive =
        new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

public DriveSystem() {
    frontRight.setInverted(true);
    rearRight.setInverted(true);
    }

public void driveCartesian(double d, double e, double f) {
}

public boolean isBusy() {
    return true;
}

public void setTargetPosition(int targetCount) {
}

public void set(double targetSpeed) {
}

}
