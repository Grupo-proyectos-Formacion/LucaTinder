package com.grupo2.lucatinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.event.EventListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.grupo2.lucatinder.model.Usuario;

@SpringBootApplication
public class LucatinderApplication implements WebMvcConfigurer {

    @Bean
    @Scope(
        value = WebApplicationContext.SCOPE_SESSION, 
        proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Usuario usuarioSesion() {
        return new Usuario();
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("---INICIALIZANDO LA APP ---");
        //ControlInicio.incializar();
        
    }
    
	public static void main(String[] args) {
		SpringApplication.run(LucatinderApplication.class, args);
	}
	
	

}
