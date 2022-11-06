package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.lang.annotation.Target;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "Team772BlueSide (Blocks to Java)")
public class Team772BlueSide extends LinearOpMode {

  private DcMotor motor1;
  private DcMotor motor2;
  private DcMotor motor3;
  private DcMotor motor4;
  private DcMotor Top;
  private DcMotor Spin;
  private DcMotor Bottom;

  int Lpos;
  int Rpos;
  int TargetPos;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    motor1 = hardwareMap.get(DcMotor.class, "motor 1");
    motor2 = hardwareMap.get(DcMotor.class, "motor 2");
    motor3 = hardwareMap.get(DcMotor.class, "motor 3");
    motor4 = hardwareMap.get(DcMotor.class, "motor 4");
    Top = hardwareMap.get(DcMotor.class, "Top");
    Spin = hardwareMap.get(DcMotor.class, "Spin");
    Bottom = hardwareMap.get(DcMotor.class, "Bottom");

    // Put initialization blocks here.
    motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    // by default motor 1 and 2 move forward.
    // by default 3 and 4 move backwards. So...
    motor3.setDirection(DcMotorSimple.Direction.REVERSE);
    motor4.setDirection(DcMotorSimple.Direction.REVERSE);
    Top.setDirection(DcMotorSimple.Direction.REVERSE);
    Rpos = 0;
    Lpos = 0;
    TargetPos = 0;
    waitForStart();
    RaiseLowerArm(20, 0.25);
  }

  /**
   * Describe this function...
   */
  private void ForwardBackward(int Target, double speed) {
    Lpos += Target;
    Rpos += Target;
    motor1.setTargetPosition(Rpos);
    motor2.setTargetPosition(Rpos);
    motor3.setTargetPosition(Lpos);
    motor4.setTargetPosition(Lpos);
    motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor1.setPower(speed);
    motor2.setPower(speed);
    motor3.setPower(speed);
    motor4.setPower(speed);
    while (opModeIsActive() && motor1.isBusy() && motor2.isBusy() && motor4.isBusy() && motor3.isBusy()) {
      idle();
    }
  }

  /**
   * Describe this function...
   */
  private void Spin_Arm(double speed, int Target) {
    // +Target moves left
    // -Target moves right
    TargetPos += Target;
    Spin.setTargetPosition(TargetPos);
    Spin.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    Spin.setPower(speed);
    while (opModeIsActive() && Spin.isBusy()) {
      idle();
    }
  }

  /**
   * Describe this function...
   */
  private void Strafe(int Ltarg, int Rtarg, double speed) {
    // To Strafe left -L and +R
    // To Strafe right -R and +L
    Lpos += Ltarg;
    Rpos += Rtarg;
    motor3.setTargetPosition(Rpos);
    motor2.setTargetPosition(Rpos);
    motor1.setTargetPosition(Ltarg);
    motor4.setTargetPosition(Lpos);
    motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor4.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    motor3.setPower(speed);
    motor2.setPower(speed);
    motor1.setPower(speed);
    motor4.setPower(speed);
    while (opModeIsActive() && motor1.isBusy() && motor2.isBusy() && motor4.isBusy() && motor3.isBusy()) {
      idle();
    }
  }

  /**
   * Describe this function...
   */
  private void RaiseLowerArm(int Target, double speed) {
    // +Target is Up
    // -Target is Down
    TargetPos += Target;
    Bottom.setTargetPosition(TargetPos);
    Top.setTargetPosition(TargetPos);
    Bottom.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    Top.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    Bottom.setPower(speed);
    Top.setPower(speed);
    while (opModeIsActive() && Bottom.isBusy() && Top.isBusy()) {
      idle();
    }
  }
}
