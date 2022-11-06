package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Team772DriverMode (Blocks to Java)")
public class Team772DriverMode extends LinearOpMode {

  private DcMotor motor1;
  private DcMotor motor2;
  private DcMotor motor3;
  private DcMotor motor4;
  private DcMotor Spin;
  private DcMotor Top;
  private DcMotor Bottom;

  /**
   * Describe this function...
   */
  private void Move() {
    if (gamepad1.dpad_up) {
      motor1.setPower(0.5);
      motor2.setPower(0.5);
      motor3.setPower(-0.5);
      motor4.setPower(-0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
    if (gamepad1.dpad_down) {
      motor1.setPower(-0.5);
      motor2.setPower(-0.5);
      motor3.setPower(0.5);
      motor4.setPower(0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
    if (gamepad1.dpad_left) {
      motor1.setPower(0.5);
      motor2.setPower(-0.5);
      motor3.setPower(0.5);
      motor4.setPower(-0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
    if (gamepad1.dpad_right) {
      motor1.setPower(-0.5);
      motor2.setPower(0.5);
      motor3.setPower(-0.5);
      motor4.setPower(0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
  }

  /**
   * Describe this function...
   */
  private void Spin_the_Arm() {
    if (gamepad1.y) {
      Spin.setPower(-1);
    } else if (false) {
      Spin.setPower(0);
    }
    if (gamepad1.x) {
      Spin.setPower(1);
    } else {
      Spin.setPower(0);
    }
  }

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    motor1 = hardwareMap.get(DcMotor.class, "motor 1");
    motor2 = hardwareMap.get(DcMotor.class, "motor 2");
    motor3 = hardwareMap.get(DcMotor.class, "motor 3");
    motor4 = hardwareMap.get(DcMotor.class, "motor 4");
    Spin = hardwareMap.get(DcMotor.class, "Spin");
    Top = hardwareMap.get(DcMotor.class, "Top");
    Bottom = hardwareMap.get(DcMotor.class, "Bottom");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        Spin_the_Arm();
        Raise();
        Spin_The_Robot();
        Move();
        telemetry.update();
      }
    }
  }

  /**
   * Describe this function...
   */
  private void Raise() {
    if (gamepad1.right_bumper) {
      Top.setPower(1);
      Bottom.setPower(-1);
    } else {
      Top.setPower(0);
      Bottom.setPower(0);
    }
    if (gamepad1.left_bumper) {
      Top.setPower(-1);
      Bottom.setPower(1);
    } else {
      Top.setPower(0);
      Bottom.setPower(0);
    }
  }

  /**
   * Describe this function...
   */
  private void Spin_The_Robot() {
    if (gamepad1.a) {
      motor1.setPower(0.5);
      motor2.setPower(0.5);
      motor3.setPower(0.5);
      motor4.setPower(0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
    if (gamepad1.b) {
      motor1.setPower(-0.5);
      motor2.setPower(-0.5);
      motor3.setPower(-0.5);
      motor4.setPower(-0.5);
    } else {
      motor1.setPower(0);
      motor2.setPower(0);
      motor3.setPower(0);
      motor4.setPower(0);
    }
  }
}
