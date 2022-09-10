package com.gmail.jobstest18.config;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:config/auth.properties"})
public interface AuthConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();
}
