package com.example.meepmeeptesting;

import static java.lang.Thread.sleep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.Constraints;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 10)
                .setDimensions(14.5,14.5)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-2, 71, -Math.PI/2))
                .splineTo(new Vector2d(-2,33),Math.toRadians(-90))
                .splineToLinearHeading(new Pose2d(-2,40,Math.toRadians(-90)),Math.toRadians(-90))
                .setTangent(0)
                .splineToLinearHeading(new Pose2d(-36, 30, Math.toRadians(90)), -Math.PI / 3)
                .setTangent(0)
                .splineToLinearHeading(new Pose2d(-48, 12, Math.toRadians(90)), -3)
                .setTangent(-1.5)
                .setReversed(false)
                .splineToConstantHeading(new Vector2d(-48,60),Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(-58, 12, Math.toRadians(90)), -3)
                .setTangent(-1.5)
                .setReversed(false)
                .splineToConstantHeading(new Vector2d(-58,60),Math.toRadians(90))
                .splineToLinearHeading(new Pose2d(-64, 12, Math.toRadians(90)), -3)
                .setTangent(-1.5)
                .setReversed(false)
                .splineToConstantHeading(new Vector2d(-64,60),Math.toRadians(90))
                .setTangent(5)
                .splineToLinearHeading(new Pose2d(-40, 50, Math.toRadians(90)), -10)
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();

        Image img = null;
        try { img = ImageIO.read(new File("C:/Users/shiva/Documents/GitHub/road-runner-quickstart/MeepMeepTesting/src/main/java/com/example/meepmeeptesting/into-the-deep-meepmeep-custom-field-images-printer-friendly-v0-qsax5fraignd1.png")); }
        catch(IOException e) {}

        meepMeep.setBackground(img);


    }
}