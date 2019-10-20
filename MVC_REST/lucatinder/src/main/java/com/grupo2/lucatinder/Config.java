/*package com.grupo2.lucatinder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.grupo2.lucatinder.model.Usuario;

@EnableWebMvc
@Configuration
public class Config implements WebMvcConfigurer {

    @Bean
    @Scope(
        value = WebApplicationContext.SCOPE_SESSION, 
        proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Usuario usuarioSesion() {
        return new Usuario();
    }

}*/