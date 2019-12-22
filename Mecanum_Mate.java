/* Copyright (c) 2017 FIRST. All rights reserved.

 *

 * Redistribution and use in source and binary forms, with or without modification,

 * are permitted (subject to the limitations in the disclaimer below) provided that

 * the following conditions are met:

 *

 * Redistributions of source code must retain the above copyright notice, this list

 * of conditions and the following disclaimer.

 *

 * Redistributions in binary form must reproduce the above copyright notice, this

 * list of conditions and the following disclaimer in the documentation and/or

 * other materials provided with the distribution.

 *

 * Neither the name of FIRST nor the names of its contributors may be used to endorse or

 * promote products derived from this software without specific prior written permission.

 *

 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS

 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS

 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,

 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE

 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE

 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL

 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR

 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER

 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,

 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE

 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 */



package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

//import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.util.ElapsedTime;





/**

 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either

 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu

 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode

 * class is instantiated on the Robot Controller and executed.

 *

 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot

 * It includes all the skeletal structure that all linear OpModes contain.

 *

 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.

 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list

 */



@TeleOp(name="MecanumMateTest", group="Linear Opmode")



public class Mecanum_Mate extends LinearOpMode {





    // Declare OpMode members.

    private ElapsedTime runtime = new ElapsedTime();

    private DcMotor SF = null;

    private DcMotor SJ = null;

    private DcMotor DF = null;

    private DcMotor DJ = null;

    /*private DcMotor RidicareV = null;

    private DcMotor RidicareE = null;

    private DcMotor RoataD = null;

    private DcMotor RoataS = null;*/

    //private Servo ServoRight = null;

    //private  Servo ServoLeft = null;

    double  power   = 0.8;



    @Override

    public void runOpMode() {

        telemetry.addData("Status", "Initialized");

        telemetry.update();



        // Initialize the hardware variables. Note that the strings used here as parameters

        // to 'get' must correspond to the names assigned during the robot configuration

        // step (using the FTC Robot Controller app on the phone).

        SF  = hardwareMap.get(DcMotor.class, "Tleft_drive");

        DF = hardwareMap.get(DcMotor.class, "Tright_drive");

        SJ  = hardwareMap.get(DcMotor.class, "Bleft_drive");

        DJ = hardwareMap.get(DcMotor.class, "Bright_drive");

        /*RidicareV = hardwareMap.get(DcMotor.class,"RidicareV");

        RidicareE = hardwareMap.get(DcMotor.class,"RidicareE");

        RoataD = hardwareMap.get(DcMotor.class, "RoataD");

        RoataS = hardwareMap.get(DcMotor.class, "RoataS");*/

       //ServoLeft = hardwareMap.get (Servo.class, "Servo1");

        //ServoRight = hardwareMap.get (Servo.class, "Servo2");



        SF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        SJ.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*RidicareV.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RidicareE.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RoataD.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RoataS.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        SF.setDirection(DcMotorSimple.Direction.REVERSE);

        SJ.setDirection(DcMotorSimple.Direction.REVERSE);





        // Wait for the game to start (driver presses PLAY)

        waitForStart();

        runtime.reset();



        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {



            while (gamepad1.dpad_up) {

                SF.setPower(power);

                SJ.setPower(power);

                DF.setPower(power);

                DJ.setPower(power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_up) {

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    power=0.8;

                    break;

                }

            }





            while (gamepad1.dpad_down) {

                SF.setPower(-power);

                SJ.setPower(-power);

                DF.setPower(-power);

                DJ.setPower(-power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_down) {

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    power=0.8;

                    break;

                }

            }



            while (gamepad1.dpad_right) {

                SF.setPower(power);

                SJ.setPower(-power);

                DF.setPower(-power);

                DJ.setPower(power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_right){

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    power=0.8;

                    break;

                }

            }



            while (gamepad1.dpad_left) {

                SF.setPower(-power);

                SJ.setPower(power);

                DF.setPower(power);

                DJ.setPower(-power);

                if (gamepad1.left_trigger!=0)

                    power = 0.4;

                if (gamepad1.left_trigger==0)

                    power=0.8;

                if (!gamepad1.dpad_left) {

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    power=0.8;

                    break;

                }

            }



            while (gamepad1.y) {

                SF.setPower(0.8);

                DJ.setPower(0.8);

                if (!gamepad1.y) {

                    SF.setPower(0);

                    DJ.setPower(0);

                    break;

                }

            }

            while (gamepad1.a) {

                SJ.setPower(0.8);

                DF.setPower(0.8);

                if (!(gamepad1.a)) {

                    SJ.setPower(0);

                    DF.setPower(0);

                    break;

                }

            }

            while (gamepad1.x) {

                SF.setPower(-0.8);

                DJ.setPower(-0.8);

                if (!(gamepad1.x)) {

                    SF.setPower(0);

                    DJ.setPower(0);

                    break;

                }

            }

            while (gamepad1.b) {

                SJ.setPower(-0.8);

                DF.setPower(-0.8);

                if (!(gamepad1.b)) {

                    SJ.setPower(0);

                    DF.setPower(0);

                    break;

                }

            }

            while (gamepad1.right_bumper) {

                SF.setPower(0.8);

                SJ.setPower(0.8);

                DF.setPower(-0.8);

                DJ.setPower(-0.8);

                if (!gamepad1.right_bumper) {

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    break;

                }

            }

            while (gamepad1.left_bumper) {

                SF.setPower(-0.8);

                SJ.setPower(-0.8);

                DF.setPower(0.8);

                DJ.setPower(0.8);

                if (!gamepad1.left_bumper) {

                    SF.setPower(0);

                    SJ.setPower(0);

                    DF.setPower(0);

                    DJ.setPower(0);

                    break;

                }

            }

            /*while (gamepad1.start){
                RidicareE.setPower(power);
                RidicareV.setPower(-power);

                if(!gamepad1.start){
                    RidicareV.setPower(0);
                    RidicareE.setPower(0);
                    break;
                }

            }

            while (gamepad1.back){
                RidicareE.setPower(-power);
                RidicareV.setPower(power);

                if(!gamepad1.back){
                    RidicareV.setPower(0);
                    RidicareE.setPower(0);
                    break;
                }

            }
            while(gamepad1.right_trigger!=0){
                RoataD.setPower(power);
                RoataS.setPower(power);

                if(gamepad1.right_trigger==0){
                    RoataD.setPower(0);
                    RoataS.setPower(0);
                    break;
                }
            }*/

        }

    }
}

