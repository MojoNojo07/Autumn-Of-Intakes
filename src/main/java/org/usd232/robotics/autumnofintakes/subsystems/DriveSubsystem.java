package org.usd232.robotics.autumnofintakes.subsystems;

//import org.usd232.robotics.autumnofintakes.RobotContainer;
//import org.usd232.robotics.autumnofintakes.Constants.OIConstants;
import org.usd232.robotics.autumnofintakes.log.Logger;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// https://drive.google.com/file/d/1L3HFG1faKJ7LC5MNRQro7GX06wvOmHof/view?usp=sharing

public class DriveSubsystem extends SubsystemBase {
    /**
     * The logger.
     * 
     * @since 2018
     */
    @SuppressWarnings("unused")
    private static final Logger LOG = new Logger();

    private PWMSparkMax leftMotor1 = new PWMSparkMax(0);
    private PWMSparkMax leftMotor2 = new PWMSparkMax(1);
    private PWMSparkMax rightMotor1 = new PWMSparkMax(2);
    private PWMSparkMax rightMotor2 = new PWMSparkMax(3);

    public void drive(double left, double right){

        leftMotor1.set(left);
        leftMotor2.set(left);
        rightMotor1.set(-right);
        rightMotor2.set(-right);
    }
    
}
