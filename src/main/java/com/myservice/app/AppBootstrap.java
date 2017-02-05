package com.myservice.app;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

/**
 * загрузчик приложения
 * Created by Zloy on 04.02.2017.
 */

@WebListener
public class AppBootstrap implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(AppBootstrap.class.getName());

    private static boolean init(ServletContext e){

        return  true;
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            LOGGER.info("Context init @ " + servletContextEvent.getServletContext().getVirtualServerName());

            if (!init(servletContextEvent.getServletContext())) {
                LOGGER.fine("initialization application failed");
                return;
            }
        } catch (Exception e) {
            LOGGER.fine("Context init error: ");
            LOGGER.fine(e.getStackTrace().toString());
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
