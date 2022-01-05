package br.com.java.beanvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
// @ComponentScan(basePackageClasses = UsuarioController.class)
public class BeanvalidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanvalidationApplication.class, args);
	}

}
