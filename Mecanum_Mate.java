package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp(name="TeleOp1RobotAntrenament", group="Linear Opmode")

public class Mecanum_Mate extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor TleftDrive = null;
    private DcMotor BleftDrive = null;
    private DcMotor TrightDrive = null;
    private DcMotor BrightDrive = null;

    private DcMotor ColectorE = null;
    private DcMotor ColectorV = null;

    private DcMotor RidicareE= null;
    private DcMotor RidicareV = null;

    CRServo Brat_Cot;
    CRServo Servomotor1 ;
    CRServo Brat_Umar ;
    BNO055IMU imu;
    Orientation angles;

    double  power   = 0.7;

    @Override
    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;

        Brat_Cot = hardwareMap.get(CRServo.class, "Brat_Cot");
        Servomotor1 = hardwareMap.get(CRServo.class,"Servo1");
        Brat_Umar = hardwareMap.get(CRServo.class,"Brat_Umar");

        TleftDrive  = hardwareMap.get(DcMotor.class, "Tleft_drive");
        TrightDrive = hardwareMap.get(DcMotor.class, "Tright_drive");
        BleftDrive  = hardwareMap.get(DcMotor.class, "Bleft_drive");
        BrightDrive = hardwareMap.get(DcMotor.class, "Bright_drive");

        ColectorE= hardwareMap.get(DcMotor.class, "ColectorE");
        ColectorV = hardwareMap.get(DcMotor.class, "ColectorV");

        RidicareV = hardwareMap.get(DcMotor.class, "RidicareV");
        RidicareE = hardwareMap.get(DcMotor.class, "RidicareE");

        TleftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        TrightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BrightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BleftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RidicareV.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RidicareE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        ColectorV.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ColectorE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        TleftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        BleftDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            ColectorV.setPower(-1);
            ColectorE.setPower(1);

            while (gamepad1.dpad_up) {

                TleftDrive.setPower(power);
                BleftDrive.setPower(power);
                TrightDrive.setPower(power);
                BrightDrive.setPower(power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_up) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }

            while (gamepad1.dpad_down) {

                TleftDrive.setPower(-power);
                BleftDrive.setPower(-power);
                TrightDrive.setPower(-power);
                BrightDrive.setPower(-power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_down) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }


            while (gamepad1.dpad_left) {

                TleftDrive.setPower(power);
                BleftDrive.setPower(-power);
                TrightDrive.setPower(-power);
                BrightDrive.setPower(power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_left) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }

            while (gamepad1.dpad_right) {

                TleftDrive.setPower(-power);
                BleftDrive.setPower(power);
                TrightDrive.setPower(power);
                BrightDrive.setPower(-power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_right) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);
                    break;

                }
            }

            while (gamepad1.y) {

                TleftDrive.setPower(power);
                BrightDrive.setPower(power);

                if (!gamepad1.y) {

                    TleftDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }
            while (gamepad1.a) {

                BleftDrive.setPower(power);
                TrightDrive.setPower(power);

                if (!gamepad1.a) {

                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);

                    break;
                }
            }
            while (gamepad1.x) {

                TleftDrive.setPower(-power);
                BrightDrive.setPower(-power);

                if (!gamepad1.x) {

                    TleftDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }
            while (gamepad1.b) {

                BleftDrive.setPower(-power);
                TrightDrive.setPower(-power);

                if (!gamepad1.b) {

                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);

                    break;
                }
            }
            while (gamepad1.right_bumper) {

                TleftDrive.setPower(-power);
                BleftDrive.setPower(-power);
                TrightDrive.setPower(power);
                BrightDrive.setPower(power);

                if (!gamepad1.right_bumper) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }
            while (gamepad1.left_bumper) {

                TleftDrive.setPower(power);
                BleftDrive.setPower(power);
                TrightDrive.setPower(-power);
                BrightDrive.setPower(-power);

                if (!gamepad1.left_bumper) {

                    TleftDrive.setPower(0);
                    BleftDrive.setPower(0);
                    TrightDrive.setPower(0);
                    BrightDrive.setPower(0);

                    break;
                }
            }

            while (gamepad2.left_stick_x==1) {

                RidicareE.setPower(1);

                if(gamepad2.left_stick_x==0) {

                    RidicareE.setPower(0);

                    break;
                }
            }

            while (gamepad2.left_stick_y==1) {

                RidicareE.setPower(-1);

                if(gamepad2.left_stick_y==0) {

                    RidicareE.setPower(0);

                    break;
                }
            }

            while (gamepad2.right_stick_x==1) {

                RidicareV.setPower(1);

                if (gamepad2.right_stick_x==0) {

                    RidicareV.setPower(0);

                    break;
                }
            }

            while (gamepad2.right_stick_y==1) {

                RidicareV.setPower(-1);

                if (gamepad2.right_stick_y==0) {

                    RidicareV.setPower(0);

                    break;
                }
            }

            while (gamepad2.dpad_up){

                Servomotor1.setPower(1);

                if(!gamepad2.dpad_up){

                    Servomotor1.setPower(0);

                    break;
                }
            }

            while (gamepad2.dpad_down) {

                Servomotor1.setPower(-1);

                if(!gamepad2.dpad_down){

                    Servomotor1.setPower(0);

                    break;
                }
            }

            while (gamepad2.right_bumper){

                Brat_Umar.setPower(1);

                if(!gamepad2.right_bumper){

                    Brat_Umar.setPower(0);

                    break;
                }
            }

            while (gamepad2.left_bumper) {

                Brat_Umar.setPower(-1);

                if(!gamepad2.left_bumper){

                    Brat_Umar.setPower(0);

                    break;
                }
            }
        }
    }
}