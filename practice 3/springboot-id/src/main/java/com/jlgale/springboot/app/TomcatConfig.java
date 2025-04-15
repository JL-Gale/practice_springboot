package com.jlgale.springboot.app;

import org.apache.catalina.Context;
import org.apache.catalina.session.StandardManager;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class TomcatConfig {
    // Configuracion no aplicada por complejidad, pero funciona xd
    // Configuracion para que el tomcat no guarde sesiones en el disco duro
    // y no salten errores a la hora de volver a levantar el proyecto

    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> sessionPersistenceCustomizer() {
        return factory -> {
            factory.addContextCustomizers(context -> {
                // Obtiene el Manager actual (usualmente StandardManager)
                org.apache.catalina.Manager manager = context.getManager();

                // Si no hay manager o no es StandardManager, no hacemos nada
                // (aunque por defecto en Tomcat embebido suele ser StandardManager)
                if (manager == null) {
                    // Podrías crear uno nuevo si fuera necesario, pero para deshabilitar
                    // la persistencia, asumimos que ya existe uno por defecto.
                    // Si quieres asegurarte, podrías poner: manager = new StandardManager(); context.setManager(manager);
                    manager = new StandardManager();
                    context.setManager(manager);
                }

                // La clave: establece el pathname a una cadena vacía.
                // Esto le dice al StandardManager que NO guarde/cargue las sesiones
                // desde/hacia un archivo (como SESSIONS.ser).
                if (manager instanceof StandardManager) {
                    ((StandardManager) manager).setPathname(""); // <-- Línea importante
                    // Alternativamente, si sólo quieres deshabilitar el guardado al apagar:
                    // ((StandardManager) manager).setSaveOnRestart(false); // Aunque setPathname("") es más común para deshabilitar por completo
                }
                // Opcional: Si quieres asegurarte que no cargue al inicio tampoco
                // ((StandardManager) manager).setLoadOnStartup(false); // Ya implícito con pathname=""

            });
        };
    }
}
