package com.gmail.jobstest18.owner;

import com.gmail.jobstest18.config.Browser;
import com.gmail.jobstest18.config.TypesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TypesTest {

    @Test
    public void testInteger() {
        System.setProperty("integer", "10");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(10);
    }

    @Test
    public void testDouble() {
        System.setProperty("double", "10.10");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getDouble()).isEqualTo(10.10);
    }

    @Test
    public void testBoolean() {
        System.setProperty("boolean", "true");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getBoolean()).isEqualTo(true);
    }

    @Test
    public void testEnum() {
        System.setProperty("enum", "CHROME");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getEnum()).isEqualTo(Browser.CHROME);
    }

    @Test
    public void testURL() {
        System.setProperty("url", "https://selenium:4444/wd/hub");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getURL())
                .hasHost("selenium")
                .hasProtocol("https");
    }
}
