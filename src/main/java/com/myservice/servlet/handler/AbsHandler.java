package com.myservice.servlet.handler;

/**
 * абстрактный выполнятель запросов
 * Created by Zloy on 04.02.2017.
 */
public abstract class AbsHandler<T extends APIRequest,V extends APIResponse> {
     public abstract Class getClassRequest();
     public abstract Class getClassResponse();
     public abstract String getNameHandler();
     public abstract V execute(T request) throws Exception;
}
