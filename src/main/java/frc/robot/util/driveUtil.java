package frc.robot.util;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.teleop.Robot;

/*Because tyra can't remember what she calleed the motors
*   |
*   v
* frontLeft, rearLeft, frontRight, rearRight */
public class driveUtil extends SubsystemBase {

 //there is probably a better way to call the motors but idk what that is
public static Robot m_robotDrive = new Robot();
public static Robot frontLeft = new Robot();
public static Robot frontRight = new Robot();
public static Robot rearLeft = new Robot();
public static Robot rearRight = new Robot();

//the purpose of this is to convert our revolutions per minute (RPM) into distance traveled
static final double COUNTS_PER_MOTOR_REV = 10620;  //*2 adjust for mecanum
static final double WHEEL_DIAMETER = 15.24;     // In centimeters
static final double WHEEL_RADIUS = WHEEL_DIAMETER/2; // in cm
static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * Math.PI;
static final double GEAR_REDUCTION = 1.0; // output (wheel) speed / input (motor) speed
static final double COUNTS_PER_GEAR_REV = COUNTS_PER_MOTOR_REV * GEAR_REDUCTION;
static final double COUNTS_PER_DEGREE = COUNTS_PER_GEAR_REV/360;
//track width 43.353 cm

//utility commands
public void stopRobot(){
    m_robotDrive.set(0);
}

public void WaitCommand​(double seconds) {
    m_robotDrive.set(seconds);
}

public void driveRobotDistanceForward(double distanceInCM, double targetSpeed) {
    int targetCount;
    //convert sentimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopRobot();

    frontLeft.set(targetCount);
    frontRight.set(targetCount);
    rearLeft.set(targetCount);
    rearRight.set(targetCount);
//conitnue driving until all of the motors hits the distance
    while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
    || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }
stopRobot();

}

public void driveRobotDistanceBackward(double distanceInCM, double targetSpeed) {
    int targetCount;
    //convert sentimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopRobot();

    frontLeft.set(targetCount);
    frontRight.set(targetCount);
    rearLeft.set(targetCount);
    rearRight.set(targetCount);

//conitnue driving until all of the motors hits the distance
    while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
    || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }
stopRobot();

}

public void driveRobotDistanceStrafeRight(double distanceInCM, double targetSpeed) {
    int targetCount;
    //convert sentimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopRobot();

    frontLeft.set(targetCount);
    frontRight.set(-targetCount);
    rearLeft.set(-targetCount);
    rearRight.set(targetCount);

//conitnue driving until all of the motors hits the distance
    while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
        || rearRight.isBusy()) {
    // Send calculated power to wheels
        frontLeft.set(targetSpeed);
        frontRight.set(targetSpeed);
        rearLeft.set(targetSpeed);
        rearRight.set(targetSpeed);
        }
        
    stopRobot();
}

public void driveRobotDistanceStrafeLeft(double distanceInCM, double targetSpeed) {
    int targetCount;
    //convert sentimeters to number cycles to drive
    //counts_per_rotation/circumference*distane
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * distanceInCM);
    stopRobot();

    frontLeft.set(-targetCount);
    frontRight.set(targetCount);
    rearLeft.set(targetCount);
    rearRight.set(-targetCount);

//conitnue driving until all of the motors hits the distance
    while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
        || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
        }
        
    stopRobot();
}

public void rotateRight90Degrees(double targetSpeed) {
    int targetCount;
    double diameter = 79.708;//diameter in cms measured between left front and right rear or RF and LR

    //convert centimeters to number cycles to drive
    //to make a 90 degree turn, use diameter divide by four; so, diameter * pi / 4
    // counts_per_rotation/circumference*
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * diameter * Math.PI / 4);

    //ensure full stop and reset motors to begin counting movement
    stopRobot();
    //revere motors
  //  reverseMotor(right_front_motor);
  //  reverseMotor(right_rear_motor);

    //set target stop and mode for running to a position
    frontLeft.setTargetPosition(targetCount);
    frontRight.setTargetPosition(-targetCount);
    rearLeft.setTargetPosition(targetCount);
    rearRight.setTargetPosition(-targetCount);

//conitnue driving until all of the motors hits the distance
   while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
   || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }//end while

    stopRobot();
}

public void rotateLeft90Degrees(double targetSpeed) {
    int targetCount;
    double diameter = 79.708;//diameter in cms measured between left front and right rear or RF and LR

    //convert centimeters to number cycles to drive
    //to make a 90 degree turn, use diameter divide by four; so, diameter * pi / 4
    // counts_per_rotation/circumference*
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * diameter * Math.PI / 4);

    //ensure full stop and reset motors to begin counting movement
    stopRobot();
    //revere motors
  //  reverseMotor(right_front_motor);
  //  reverseMotor(right_rear_motor);

    //set target stop and mode for running to a position
    frontLeft.setTargetPosition(-targetCount);
    frontRight.setTargetPosition(targetCount);
    rearLeft.setTargetPosition(-targetCount);
    rearRight.setTargetPosition(targetCount);

//conitnue driving until all of the motors hits the distance
   while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
   || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }//end while

    stopRobot();
}

public void rotateRight45Degrees(double targetSpeed) {
    int targetCount;
    double diameter = 79.708;//diameter in cms measured between left front and right rear or RF and LR

    //convert centimeters to number cycles to drive
        //to make a 90 degree turn, use diameter / 4; so, diameter * pi / 8
        // counts_per_rotation/circumference*
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * diameter * Math.PI / 8);

    //ensure full stop and reset motors to begin counting movement
    stopRobot();
    //revere motors
  //  reverseMotor(right_front_motor);
  //  reverseMotor(right_rear_motor);

    //set target stop and mode for running to a position
    frontLeft.setTargetPosition(targetCount);
    frontRight.setTargetPosition(-targetCount);
    rearLeft.setTargetPosition(targetCount);
    rearRight.setTargetPosition(-targetCount);

//conitnue driving until all of the motors hits the distance
   while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
   || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }//end while

    stopRobot();
}

public void rotateLeft45Degrees(double targetSpeed) {
    int targetCount;
    double diameter = 79.708;//diameter in cms measured between left front and right rear or RF and LR

    //convert centimeters to number cycles to drive
        //to make a 90 degree turn, use diameter / 4; so, diameter * pi / 8
        // counts_per_rotation/circumference*
    targetCount = (int) Math.round(COUNTS_PER_GEAR_REV / WHEEL_CIRCUMFERENCE * diameter * Math.PI / 8);

    //ensure full stop and reset motors to begin counting movement
    stopRobot();
    //revere motors
  //  reverseMotor(right_front_motor);
  //  reverseMotor(right_rear_motor);

    //set target stop and mode for running to a position
    frontLeft.setTargetPosition(-targetCount);
    frontRight.setTargetPosition(targetCount);
    rearLeft.setTargetPosition(-targetCount);
    rearRight.setTargetPosition(targetCount);

//conitnue driving until all of the motors hits the distance
   while (frontLeft.isBusy() || frontRight.isBusy() || rearLeft.isBusy()
   || rearRight.isBusy()) {
    // Send calculated power to wheels
    frontLeft.set(targetSpeed);
    frontRight.set(targetSpeed);
    rearLeft.set(targetSpeed);
    rearRight.set(targetSpeed);
    }//end while

    stopRobot();
}
}
