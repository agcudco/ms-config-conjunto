package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Ocupacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OcupacionRepository extends JpaRepository<Ocupacion, UUID> {

    Optional<Ocupacion> findByIdAndDeletedAtIsNull(UUID id);
    Page<Ocupacion> findByUnidad_IdAndDeletedAtIsNull(UUID unidadId, Pageable pageable);
    Page<Ocupacion> findByPersonaIdAndDeletedAtIsNull(UUID personaId, Pageable pageable);
    Page<Ocupacion> findByUnidad_IdAndFechaFinIsNullAndDeletedAtIsNull(UUID unidadId, Pageable pageable);
}
