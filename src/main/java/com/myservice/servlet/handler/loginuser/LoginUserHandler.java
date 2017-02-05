package com.myservice.servlet.handler.loginuser;

import com.myservice.Util.UtilApp;
import com.myservice.app.AppBootstrap;
import com.myservice.data.HibernateSessionFactory;
import com.myservice.data.manager.UserManager;
import com.myservice.data.pojo.Group;
import com.myservice.data.pojo.User;
import com.myservice.servlet.handler.AbsHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Logger;

/**
 * handler ообслуживающий запрос loginUser
 * Created by Zloy on 04.02.2017.
 */
public class LoginUserHandler extends AbsHandler <LoginUserRequest,LoginUserResponse> {

    private static final Logger LOGGER = Logger.getLogger(LoginUserHandler.class.getName());

    public Class getClassRequest(){
        return LoginUserRequest.class;
    }

    public Class getClassResponse(){
        return LoginUserResponse.class;
    }

    @Override
    public String getNameHandler() {
        return "loginUser";
    }


    @Override
    public LoginUserResponse execute(LoginUserRequest request) throws Exception {
        LOGGER.info(request == null ? null : request.toString());

        if (UtilApp.isEmpty(request.getUser())) throw new Exception(); //todo впилить исключения

        UserManager user = UserManager.getUserByLogin(request.getUser());

        //if(user == null) //todo впилить исключения о неверном логине
        //if(user.getUser().getPassword().equals(request.getPassword()))

        return new LoginUserResponse();
    }

}
