package com.grupo2.lucatinder.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;
import com.grupo2.lucatinder.model.Usuario;



@Component
public class DaoUsuarioFake  {
	
	 public static List<Usuario> listaUsuario() {
	     
		 ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		 
		 Locale locale= new Locale("es");
		 Faker faker = new Faker(locale);
		
		
			
			 for (int i=0; i<35;i++) {
				  				 
				 String nombre= faker.name().firstName();
				 int edad= faker.number().numberBetween(18, 80);
				 String ciudad= faker.address().cityName();
				 String descripcion= faker.friends().quote();
				 boolean sexo = new Random().nextBoolean();
				 if(nombre.endsWith("a")) {
					 sexo =false;
				 } else if(nombre.endsWith("o")) {
					 sexo=true;
				 }
				 
				 
				 String imagen;
				 if(sexo) {
					 imagen = "https://randomuser.me/api/portraits/men/"+i+".jpg";
				 } else imagen = "https://randomuser.me/api/portraits/women/"+i+".jpg";
				 
				 new Usuario(nombre,descripcion,edad,ciudad,sexo,imagen);	 
				 listaUsuario.add(new Usuario(nombre,descripcion,edad,ciudad,sexo,imagen));
				 
				 
			 
			 }
			return listaUsuario;
			 
	 }
	
	
	
	

}
