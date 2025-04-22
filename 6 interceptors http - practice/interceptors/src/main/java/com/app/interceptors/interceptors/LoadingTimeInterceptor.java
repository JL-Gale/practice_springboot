package com.app.interceptors.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller = ((HandlerMethod) handler);
        LOGGER.info("LoadingTimeInterceptor: preHandler() entrando......." + controller.getMethod().getName());

        long star = System.currentTimeMillis();
        request.setAttribute("start", star);
//        Thread.sleep(new Random().nextInt(5000, 5500));

        Map<String, String> body = new HashMap<>();
        body.put("error", "no tienes acceso a esta pagina");
        body.put("date", new Date().toString());

        ObjectMapper mapper = new ObjectMapper();
        String jsonStrin = mapper.writeValueAsString(body);

        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(jsonStrin);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        Long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        long result = end - start;
        LOGGER.info("Tiempo transcurrido: "+result+" milisegundos");
        LOGGER.info("LoadingTimeInterceptor: posHandler() saliendo......." + ((HandlerMethod) handler).getMethod().getName());
    }


}
