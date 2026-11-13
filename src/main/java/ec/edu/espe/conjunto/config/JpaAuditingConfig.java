package ec.edu.espe.conjunto.config;

import java.util.Optional;
import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
    // Sustituir por el UUID del usuario autenticado (JWT) al integrar seguridad.
    // No utiliza una tabla local de personas.
    @Bean
    AuditorAware<UUID> auditorProvider() {
        return Optional::empty;
    }
}
