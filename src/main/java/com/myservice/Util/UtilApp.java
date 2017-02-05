package com.myservice.Util;

/**
 * Created by Zloy on 05.02.2017.
 */
public class UtilApp {

    public static boolean isEmpty(String ... params){
        for(String param: params){
            if(param == null && param.isEmpty()) return true;
        }
        return false;
    }
}
