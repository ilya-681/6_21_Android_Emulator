package config;

import org.aeonbits.owner.ConfigFactory;

public class Device {
    public static DeviceConfig config = ConfigFactory.create(DeviceConfig.class, System.getProperties());
}
