package com.jlgale.springboot.app;

import com.jlgale.springboot.app.models.Item;
import com.jlgale.springboot.app.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.apache.catalina.session.StandardManager;
import org.apache.catalina.core.StandardContext;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties") // -> se estan inyectando algunas propiedades
public class ConfigApp {

    // listas que estan siendo inyectadas en invoice como parametros
    // se supone que iminita de manera primitiva una base de datos
    @Bean
    List<Item> listItem1() {
        Product product1 = new Product("Play Station", 1000);
        Product product2 = new Product("Play Station", 1000);
        return Arrays.asList(new Item(product1, 2), new Item(product2, 3));
    }

    @Bean
    List<Item> listItem2() {
        Product product1 = new Product("Play Station 2", 1000);
        Product product2 = new Product("Play Station 2", 1000);
        return Arrays.asList(new Item(product1, 2), new Item(product2, 3));
    }

    // Configuracion para que el tomcat no guarde sesiones en el disco duro
    // y no salten errores a la hora de volver a levantar el proyecto
    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        factory.addContextCustomizers((TomcatContextCustomizer) context -> {
            if (context instanceof StandardContext standardContext) {
                StandardManager manager = new StandardManager();
                manager.setPathname(null); // <- Esto evita que se escriba el archivo .ser
                standardContext.setManager(manager);
            }
        });
        return factory;
    }
}
