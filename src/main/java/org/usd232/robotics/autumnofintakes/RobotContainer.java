package org.usd232.robotics.autumnofintakes;

import org.usd232.robotics.autumnofintakes.log.Logger;
import org.usd232.robotics.autumnofintakes.subsystems.DriveSubsystem;
import org.usd232.robotics.autumnofintakes.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

import static org.usd232.robotics.autumnofintakes.Constants.*;

import org.usd232.robotics.autumnofintakes.commands.Intake;

// https://drive.google.com/file/d/1EBKde_UrpQlax-PRKJ1Qa8nDJuIpd07K/view?usp=sharing

public class RobotContainer {
    /**
     * The logger.
     *
     * @since 2018
     */
    @SuppressWarnings("unused")
    private static final Logger LOG = new Logger();

    public final DriveSubsystem driveSubsystem = new DriveSubsystem();
    public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        // Configure the button bindings
        configureButtonBindings();
    }

    private void configureButtonBindings() {

        //Intakes when A is held
        IO.ManipulatorXbox_A.whileHeld(new Intake(1.0, intakeSubsystem));

        //Reverses intake when B is held
        IO.ManipulatorXbox_B.whileHeld(new Intake(-1.0, intakeSubsystem));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }

    /** Sets the deadzone for the controller/joystick */
    private static double deadband(double value, double deadband) {
        if (Math.abs(value) > deadband) {
            if (value > 0.0) {
                return (value - deadband) / (1.0 - deadband);
            } else {
                return (value + deadband) / (1.0 - deadband);
            }
        } else {
            return 0.0;
        }
    }

    /** Applies deadband and Copies the sign */
    public static double modifyAxis(double value) {
        // Deadband
        value = deadband(value, OIConstants.DEADBAND);

        // Square the axis
        value = Math.copySign(value * value, value);

        return value;
    }
}
