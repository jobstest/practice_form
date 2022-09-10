package com.gmail.jobstest18.owner;

import com.gmail.jobstest18.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileTest {

    @Test
    public void testAndroid() {
        System.setProperty("device", "pixel");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("27.0");
        assertThat(config.deviceName()).isEqualTo("Google Pixel XL");
    }

    @Test
    public void testIphone() {
        System.setProperty("device", "iphone12");

        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("15.0");
        assertThat(config.deviceName()).isEqualTo("iPhone 15");
    }
}
