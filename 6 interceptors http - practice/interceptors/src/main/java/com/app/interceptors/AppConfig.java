package com.app.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(timeInterceptor).excludePathPatterns() // para excluir a una ruta especifica o rutas especificas
//        registry.addInterceptor(timeInterceptor).addPathPatterns() // para ejecutar en una ruta especifica o rutas especifica
//        registry.addInterceptor(timeInterceptor); // si no colocamos nada se ejecuta en todas las rutas hasta en las que no existen
        registry.addInterceptor(timeInterceptor).addPathPatterns("/api/test1", "/api/test2");
    }
}
