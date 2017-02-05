package com.myservice.servlet.handler.loginuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myservice.servlet.handler.APIRequest;

/**
 * Created by Zloy on 04.02.2017.
 */
public class LoginUserRequest implements APIRequest {
    @JsonProperty
    private String user;

    @JsonProperty
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LoginUserRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
