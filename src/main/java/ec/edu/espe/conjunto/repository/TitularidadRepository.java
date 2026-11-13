package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Titularidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TitularidadRepository extends JpaRepository<Titularidad, UUID> {

    Optional<Titularidad> findByIdAndDeletedAtIsNull(UUID id);
    Page<Titularidad> findByUnidad_IdAndDeletedAtIsNull(UUID unidadId, Pageable pageable);
    Page<Titularidad> findByPersonaIdAndDeletedAtIsNull(UUID personaId, Pageable pageable);
    Page<Titularidad> findByUnidad_IdAndFechaFinIsNullAndDeletedAtIsNull(UUID unidadId, Pageable pageable);
    boolean existsByUnidad_IdAndPersonaIdAndFechaFinIsNullAndDeletedAtIsNull(UUID unidadId, UUID personaId);
}
