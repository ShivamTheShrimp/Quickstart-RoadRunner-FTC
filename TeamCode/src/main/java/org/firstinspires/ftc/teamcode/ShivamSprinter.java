package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="ShivamSprinter")
public class ShivamSprinter extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(-2,71,-Math.PI/2));
        waitForStart();

        while (opModeIsActive()) {
            Actions.runBlocking(
                    drive.actionBuilder(new Pose2d(-2, 71, -Math.PI/2))
                            .splineTo(new Vector2d(-2,50),Math.toRadians(-90))
                            .splineToLinearHeading(new Pose2d(-2,40,Math.toRadians(-90)),Math.toRadians(-90))
                            .setTangent(0)
                            .splineToLinearHeading(new Pose2d(-36, 30, Math.toRadians(90)), -Math.PI / 3)
                            .setTangent(0)
                            .splineToLinearHeading(new Pose2d(-48, 12, Math.toRadians(90)), -3)
                            .setTangent(-1.5)
                            .setReversed(false)
                            .splineToConstantHeading(new Vector2d(-48,50),Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-58, 12, Math.toRadians(90)), -3)
                            .setTangent(-1.5)
                            .setReversed(false)
                            .splineToConstantHeading(new Vector2d(-58,50),Math.toRadians(90))
                            .splineToLinearHeading(new Pose2d(-64, 12, Math.toRadians(90)), -3)
                            .setTangent(-1.5)
                            .setReversed(false)
                            .splineToConstantHeading(new Vector2d(-64,60),Math.toRadians(90))
                            .setTangent(5)
                            .splineToLinearHeading(new Pose2d(-40, 50, Math.toRadians(90)), -10)
                            .build());
                            sleep(10000000);


        }
    }
}
