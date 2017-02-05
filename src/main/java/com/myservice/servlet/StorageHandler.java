package com.myservice.servlet;

import com.myservice.servlet.handler.APIRequest;
import com.myservice.servlet.handler.APIResponse;
import com.myservice.servlet.handler.AbsHandler;
import com.myservice.servlet.handler.loginuser.LoginUserHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zloy on 04.02.2017.
 */
public class StorageHandler {
    private static Map<String, AbsHandler<APIRequest,APIResponse>> storage = new HashMap<>();
    static {
        addStorage(new LoginUserHandler());

    }

    private static void addStorage(AbsHandler handler){
        storage.put("/client-api/" + handler.getNameHandler().toLowerCase(), handler);
    }

    public static AbsHandler<APIRequest, APIResponse> getHandler(String path){
        return path == null ? null : storage.get(path.toLowerCase());
    }

}
