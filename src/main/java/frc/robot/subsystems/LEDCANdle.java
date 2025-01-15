package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdleConfiguration;
import com.ctre.phoenix.led.RainbowAnimation;
import com.ctre.phoenix.led.CANdle.LEDStripType;
import com.ctre.phoenix.led.CANdle.VBatOutputMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDCANdle extends SubsystemBase {
  private final CANdle CANdle;
  private final CANdleConfiguration CANdleConfiguration;

// Initialize the LEDCANdle's configuration
public LEDCANdle() {
  // Creates a new CANdle with ID 0
  this.CANdle = new CANdle(0);
  this.CANdleConfiguration = new CANdleConfiguration();
  this.CANdleConfiguration.stripType = LEDStripType.RGB;
  this.CANdleConfiguration.statusLedOffWhenActive = false;
  // Makes the CANdle not disable when it loses communication to the controller
  this.CANdleConfiguration.disableWhenLOS = false;
  // Can be set to 0.5 for half brightness, 1 for full brightness, etc.
  this.CANdleConfiguration.brightnessScalar = 1;
  this.CANdleConfiguration.vBatOutputMode = VBatOutputMode.Modulated;
  // Configures all persistent settings
  this.CANdle.configAllSettings(this.CANdleConfiguration, 100);
}

  // Use RGB values to set the color of all the LEDs
  public void setColor(int r, int g, int b) {
    this.CANdle.setLEDs(r, g, b);
    // Modulates the VBat output to the specified duty cycle percentage
    this.CANdle.modulateVBatOutput(0.95);
}

@Override
  public void periodic() {
    SmartDashboard.putString("LED State", this.getCurrentState().toString());
  }

    /** 
     * @param brightness
     * 1 is max brightness
     * @param speed
     * 0.5 is half speed
     * @param LEDs
     * 8 is the number of LEDs (Might need to change)
    */
  public void setRainbow() {
    this.CANdle.animate(new RainbowAnimation(1, 0.5, 8));
  }


//Could add a variable and method to check the current state of the LEDs



}