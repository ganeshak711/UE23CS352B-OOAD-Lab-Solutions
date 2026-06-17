import java.util.Scanner;

// Abstract Class
abstract class SmartDevice {
    protected int deviceId;
    protected String deviceName;
    protected boolean powerStatus;
    protected double powerConsumption;

    SmartDevice(int deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.powerStatus = false;
    }

    void turnOn() {
        powerStatus = true;
    }

    void turnOff() {
        powerStatus = false;
    }

    abstract double calculatePowerConsumption();

    void displayDeviceDetails() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Power Status: " + (powerStatus ? "ON" : "OFF"));
        System.out.printf("Power Consumption: %.2f", powerConsumption);
    }
}

// SmartLight
class SmartLight extends SmartDevice {
    private double wattage;

    SmartLight(int deviceId, String deviceName, double wattage) {
        super(deviceId, deviceName);
        this.wattage = wattage;
        this.powerConsumption = calculatePowerConsumption();
    }

    @Override
    double calculatePowerConsumption() {
        return wattage * 5;
    }
}

// SmartFan
class SmartFan extends SmartDevice {
    private int speedLevel;
    private double baseWattage;

    SmartFan(int deviceId, String deviceName, int speedLevel, double baseWattage) {
        super(deviceId, deviceName);
        this.speedLevel = speedLevel;
        this.baseWattage = baseWattage;
        this.powerConsumption = calculatePowerConsumption();
    }

    @Override
    double calculatePowerConsumption() {
        return baseWattage * speedLevel * 3;
    }
}

// SmartAC
class SmartAC extends SmartDevice {
    private int temperatureSetting;
    private double powerRating;

    SmartAC(int deviceId, String deviceName, int temperatureSetting, double powerRating) {
        super(deviceId, deviceName);
        this.temperatureSetting = temperatureSetting;
        this.powerRating = powerRating;
        this.powerConsumption = calculatePowerConsumption();
    }

    @Override
    double calculatePowerConsumption() {
        return powerRating * 8;
    }
}

public class Inheritance_Abstraction_Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > 3) return;

        if (!sc.hasNextInt()) return;
        int deviceId = sc.nextInt();
        sc.nextLine();

        if (deviceId < 1 || deviceId > 1000000) return;

        String deviceName = sc.nextLine();

        SmartDevice device = null;

        switch (choice) {
            case 1:
                if (!sc.hasNextDouble()) return;
                double wattage = sc.nextDouble();
                if (wattage < 0 || wattage > 5000) return;
                device = new SmartLight(deviceId, deviceName, wattage);
                break;
            case 2:
                if (!sc.hasNextInt()) return;
                int speedLevel = sc.nextInt();
                if (!sc.hasNextDouble()) return;
                double baseWattage = sc.nextDouble();
                if (speedLevel < 1 || speedLevel > 5 ||
                    baseWattage < 0 || baseWattage > 5000) return;
                device = new SmartFan(deviceId, deviceName, speedLevel, baseWattage);
                break;
            case 3:
                if (!sc.hasNextInt()) return;
                int temperatureSetting = sc.nextInt();
                if (!sc.hasNextDouble()) return;
                double powerRating = sc.nextDouble();
                if (temperatureSetting < 16 || temperatureSetting > 30 ||
                    powerRating < 0 || powerRating > 5000) return;
                device = new SmartAC(deviceId, deviceName, temperatureSetting, powerRating);
                break;
        }

        device.turnOn();
        device.displayDeviceDetails();
        sc.close();
    }
}
