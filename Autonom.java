package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@Disabled
@Autonomous(name="Autonom", group="Linear Opmode")
public class Autonom extends LinearOpMode {

    public DcMotor SF = null;
    public DcMotor SJ = null;
    public DcMotor DF = null;
    public DcMotor DJ = null;

    public DcMotor RidicareV = null;
    public DcMotor RidicareE = null;

    public DcMotor ColectorV = null;
    public DcMotor ColectorE = null;

    CRServo Servomotor1;
    CRServo Brat_Umar;
    CRServo Brat_Cot;

    BNO055IMU imu;
    Orientation angles;

    @Override
    public void runOpMode() {

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;

        SF = hardwareMap.get(DcMotor.class, "Tleft_drive");
        SJ = hardwareMap.get(DcMotor.class, "Bleft_drive");
        DF = hardwareMap.get(DcMotor.class, "Tright_drive");
        DJ = hardwareMap.get(DcMotor.class, "Bright_drive");

        RidicareE = hardwareMap.get(DcMotor.class, "RidicareE");
        RidicareV = hardwareMap.get(DcMotor.class, "RidicareV");

        ColectorE = hardwareMap.get(DcMotor.class, "ColectorE");
        ColectorV = hardwareMap.get(DcMotor.class, "ColectorV");

        Servomotor1 = hardwareMap.get(CRServo.class, "Servo1");
        Brat_Umar = hardwareMap.get(CRServo.class, "Brat_Umar");
        Brat_Cot = hardwareMap.get(CRServo.class, "Brat_Cot");

        SF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        SJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RidicareE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RidicareV.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ColectorE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ColectorV.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SF.setDirection(DcMotorSimple.Direction.REVERSE);
        SJ.setDirection(DcMotorSimple.Direction.REVERSE);

        SF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        SJ.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        DJ.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        RidicareE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RidicareV.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        ColectorE.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ColectorV.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        LateralaS(0.5, 2700);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,AngleUnit.DEGREES);
            telemetry.addData("Heading:",angles.firstAngle);
            telemetry.addData("Heading:",angles.secondAngle);
            telemetry.addData("Heading:",angles.thirdAngle);
            telemetry.update();
        }

        SF.setPower(0);
        SJ.setPower(0);
        DF.setPower(0);
        DJ.setPower(0);
        sleep(500);

        Inainte(0.8, 700);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,AngleUnit.DEGREES);
            telemetry.addData("Heading:",angles.firstAngle);
            telemetry.addData("Heading:",angles.secondAngle);
            telemetry.addData("Heading:",angles.thirdAngle);
            telemetry.update();
        }
        SF.setPower(0);
        SJ.setPower(0);
        DF.setPower(0);
        DJ.setPower(0);
        sleep(500);

        /*LateralaS(0.5, 1600);
         while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,AngleUnit.DEGREES);
            telemetry.addData("Heading:",angles.firstAngle);
            telemetry.addData("Heading:",angles.secondAngle);
            telemetry.addData("Heading:",angles.thirdAngle);
            telemetry.update();
        }

        SF.setPower(0);
        SJ.setPower(0);
        DF.setPower(0);
        DJ.setPower(0);
        sleep(500);

        Inainte(0.8, 3700);
         while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,AngleUnit.DEGREES);
            telemetry.addData("Heading:",angles.firstAngle);
            telemetry.addData("Heading:",angles.secondAngle);
            telemetry.addData("Heading:",angles.thirdAngle);
            telemetry.update();
        }
        SF.setPower(0);
        SJ.setPower(0);
        DF.setPower(0);
        DJ.setPower(0);
        sleep(500);

        Inainte(0.8, 1000);
        while(opModeIsActive() && !isStopRequested() && SF.isBusy() && SJ.isBusy() && DF.isBusy() && DJ.isBusy()) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC,AxesOrder.ZYX,AngleUnit.DEGREES);
            telemetry.addData("Heading:",angles.firstAngle);
            telemetry.addData("Heading:",angles.secondAngle);
            telemetry.addData("Heading:",angles.thirdAngle);
            telemetry.update();
        }

        SF.setPower(0);
        SJ.setPower(0);
        DF.setPower(0);
        DJ.setPower(0);
        sleep(500);*/
    }

public void Inainte(double p, int t) {
    SF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    SJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    DF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    DJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    SF.setTargetPosition(-t);
    SJ.setTargetPosition(-t);
    DF.setTargetPosition(-t);
    DJ.setTargetPosition(-t);

    SF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    SJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    DF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    DJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    SF.setPower(p);
    SJ.setPower(p);
    DF.setPower(p);
    DJ.setPower(p);


    }

public void LateralaS(double p, int t) {
        SF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        SJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DJ.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        SF.setTargetPosition(-t);
        SJ.setTargetPosition(t);
        DF.setTargetPosition(t);
        DJ.setTargetPosition(-t);

        SF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        SJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        DF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        DJ.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        SF.setPower(p);
        SJ.setPower(p);
        DF.setPower(p);
        DJ.setPower(p);

        }
}
