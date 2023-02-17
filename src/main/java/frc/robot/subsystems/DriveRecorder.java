// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Robot;
import frc.robot.RobotContainer;

// Subsystem to take recordings of the robot's movements then play them back.

public class DriveRecorder extends SubsystemBase {

  private double tick;
  private boolean active;
  private ArrayList<ArrayList<Double>> record;

  /** Creates a new DriveRecorder. */
  public DriveRecorder() {
    tick = 0.0;
    active = false;
    SmartDashboard.putString("Record Base64", "Ready to record");
    System.out.println("Ready to record movements...");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (active) {
      ArrayList<Double> data = new ArrayList<>();
      data.add(tick);
      data.add(-RobotContainer.driveController.getLeftY());
      data.add(RobotContainer.driveController.getLeftX());
      data.add(RobotContainer.driveController.getRightX());
      record.add(data);
      tick++;
    }
  }

  public CommandBase startRecord() {
    return this.run(new Runnable() {
      @Override
      public void run() {
        if (!active) {
          record = new ArrayList<>();
          tick = 0.0;
          active = true;
          SmartDashboard.putString("Record Base64", "RECORDING");
          System.out.println("Now recording movements...");
        }
      }
    });
  }

  public CommandBase stopRecord() {
    return this.run(new Runnable() {
      @Override
      public void run() {
        if (active) {
          active = false;
          try {
            System.out.println("Stopping recording...");
            ByteArrayOutputStream stream_byte = new ByteArrayOutputStream();
            ObjectOutputStream stream_obj = new ObjectOutputStream(stream_byte);
            System.out.println("Saving recording to base64...");
            stream_obj.writeObject(record);
            stream_obj.flush();
            stream_obj.close();
            String record_base64 = Base64.getEncoder().encode(stream_byte.toByteArray()).toString();
            System.out.println("Saving done.");
            SmartDashboard.putString("Record Base64", record_base64);
            System.out.println("Base64 recording: " + record_base64);
          } catch (IOException e) {
            SmartDashboard.putString("Record Base64", "Unable to convert to base64. See console logs.");
            e.printStackTrace();
          }
        }
      }
    });
  }
}
