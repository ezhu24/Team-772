package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import java.lang.annotation.Target;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TestAutonomous{

public static void main(){

Team772BlueSide robot = new Team772BlueSide();

robot.ForwardBackward(538, 0.75);
robot.Strafe(-269,269,0.75);

}

}
