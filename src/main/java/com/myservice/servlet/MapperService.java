package com.myservice.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Zloy on 05.02.2017.
 */
public class MapperService {

    private static final Logger LOGGER = Logger.getLogger(MapperService.class.getName());

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static <T> T read(String sourceStr, Class<T> clazz) {
        try {
            return MAPPER.readValue(sourceStr, clazz);
        }
        catch (IOException e) {
            LOGGER.info("error write request");
            return null;
        }
    }

    public static <T> void write(HttpServletResponse target, T object)  {
        try {
            MAPPER.writeValue(target.getWriter(), object);
            String strResponse = MAPPER.writeValueAsString(object);
            target.getWriter().write(strResponse);
            LOGGER.info(strResponse);
        }
        catch (IOException e) {
            LOGGER.info("error write response");
        }
    }
}
