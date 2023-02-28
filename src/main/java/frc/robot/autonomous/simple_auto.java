package frc.robot.autonomous;

import frc.robot.util.driveUtil;
//import frc.robot.util.liftUtil;
//import frc.robot.subsystems.Claw;

public class simple_auto {
    private driveUtil drive;
    //private liftUtil lift;
    //private Claw claw;

public void BasicAuto(){
    drive.driveRobotDistanceForward(65, 0.25);
    drive.WaitCommand​(5);
    drive.driveRobotDistanceBackward(65, 0.25);
    drive.WaitCommand​(5);
    drive.driveRobotDistanceStrafeRight(65, 0.25);
    drive.WaitCommand​(5);
    drive.driveRobotDistanceStrafeLeft(65, 0.25); 
    drive.WaitCommand​(5);
    drive.rotateLeft45Degrees(0.5);
    drive.WaitCommand​(5);
    drive.rotateRight45Degrees(0.5);
    drive.WaitCommand​(5);
    drive.rotateRight90Degrees(0.5);
    drive.WaitCommand​(5);
    drive.rotateLeft90Degrees(0.5);
    drive.WaitCommand​(5);
}

}
