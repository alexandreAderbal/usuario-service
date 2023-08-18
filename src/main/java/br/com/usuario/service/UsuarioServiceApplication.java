package br.com.usuario.service;

import br.com.lib.custom.auditoria.EnableAuditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;

@SpringBootApplication
@EnableAuditor
public class UsuarioServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}
}
