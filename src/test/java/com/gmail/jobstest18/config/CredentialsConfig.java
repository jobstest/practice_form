package com.gmail.jobstest18.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

    String login();
    String password();

    String loginJenkins();
    String passwordJenkins();
}
