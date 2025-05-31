package org.example.helloeventsapp.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // appliquer CORS à toutes les routes
                .allowedOrigins("http://localhost:4200") // autoriser Angular (localhost:4200)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // méthodes autorisées
                .allowedHeaders("*") // autoriser tous les en-têtes
                .allowCredentials(true); // autoriser les cookies / jetons (si nécessaire)
    }
}
