package com.myservice.servlet;

import com.myservice.servlet.handler.APIRequest;
import com.myservice.servlet.handler.APIResponse;
import com.myservice.servlet.handler.AbsHandler;
import com.myservice.servlet.handler.loginuser.LoginUserHandler;
import com.myservice.servlet.handler.loginuser.LoginUserRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * сервлет обслуживающие rest - запросы
 * Created by Zloy on 04.02.2017.
 */

@WebServlet(urlPatterns = "/client-api/*")
public class HandlerServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(HandlerServlet.class.getName());
    private static final String PATH_PREFIX = "/client-api/";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        execute(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private void execute(HttpServletRequest req, HttpServletResponse resp) {

        String str = req.getRequestURI();
        str = str.substring(str.indexOf(PATH_PREFIX));
        AbsHandler<APIRequest,APIResponse> handler = StorageHandler.getHandler(str);
        APIRequest request = (APIRequest) MapperService.read(getParamStr(req),handler.getClassRequest());
        if(handler == null ){
            //todo Действие когда пришло что-то левое.
            return;
        }
        try {
            APIResponse response = handler.execute(request);
            MapperService.write(resp, response);
        }catch (Exception e){

        }

    }

    private String getParamStr(HttpServletRequest request){
        StringBuilder jb = new StringBuilder();
        try (BufferedReader reader = request.getReader() ){
            String line = "";
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
        }
        return jb.toString();
    }
}
