package com.app.controller.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CalenderInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;
    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance(); //--> obtenemos la fecha actual
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // --> obtenemos la hora de la fecha actual
        System.out.println(hour);

//        int hour = 6;

        if (hour >= open && hour <= close) {
            StringBuilder message = new StringBuilder("Horario de atencion a clientes");
            message.append(", atendemos las ");
            message.append(open);
            message.append(" hrs. ");
            message.append("hasta las ");
            message.append(close);
            message.append(" hrs. ");
            message.append("Gracias por su visita");
            request.setAttribute("message", message.toString()); // -> mesanje que se va mandar controller
            return true;
        } else {

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> bodyJson = new HashMap<>();
            StringBuilder message = new StringBuilder("Cerrado fuera de horario de atencion");
            message.append(" visitenos desde las ");
            message.append(open);
            message.append(" hrs. ");
            message.append("hasta las ");
            message.append(close);
            message.append(" hrs. ");
            message.append("Gracias por su visita");
            bodyJson.put("date", new Date().toString());
            bodyJson.put("message", message.toString());

            // mesaje que se mostrara por en caso de que se falso
            response.setContentType("application/json");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write(objectMapper.writeValueAsString(bodyJson));
            return false;

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}
