package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.Chassis;

public class RobotContainer {
    // Initializes the chassis subsystem
    public static final Chassis mChassis = new Chassis();
    
    // Creates the controller
    public static final XboxController mController = new XboxController(0);






    public RobotContainer() {
        // Calls the configureButtonBindings() function (see below)
        configureButtonBindings();

        // Sets the default command of the chassis so it will automtically drive
        mChassis.setDefaultCommand(new RunFieldCentricSwerve(mChassis));

    }

    private void configureButtonBindings() {
        // Makes it so that when you press the B button the gyro will reset
        new JoystickButton(mController, XboxController.Button.kB.value)
                .whenPressed(new ResetGyro(mChassis));

        // Makes it so that when you press the A button it will call the ZeroAxes() function
        new JoystickButton(mController, XboxController.Button.kA.value)
                .whileHeld(new ZeroAxes(mChassis));

    }



}
