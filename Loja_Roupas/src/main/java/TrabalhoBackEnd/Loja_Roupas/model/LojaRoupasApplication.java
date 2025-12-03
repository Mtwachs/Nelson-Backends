package TrabalhoBackEnd.Loja_Roupas.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "TrabalhoBackEnd.Loja_Roupas")
@EntityScan(basePackages = "TrabalhoBackEnd.Loja_Roupas.model")
@EnableJpaRepositories(basePackages = "TrabalhoBackEnd.Loja_Roupas.repository")
public class LojaRoupasApplication {
    public static void main(String[] args) {
        SpringApplication.run(LojaRoupasApplication.class, args);
    }
}
