package ru.pizza.eshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurity implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Разрешить все пути
                .allowedOrigins("http://26.206.104.115:5173")  // Разрешить запросы с этого origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Разрешенные HTTP-методы
                .allowedHeaders("*")  // Разрешить все заголовки
                .allowCredentials(true)  // Разрешить передачу кук и авторизационных данных
                .maxAge(3600);  // Время кэширования CORS-запросов (в секундах)
    }
}