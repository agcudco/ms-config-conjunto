package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Piso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PisoRepository extends JpaRepository<Piso, UUID> {

    Optional<Piso> findByIdAndDeletedAtIsNull(UUID id);
    Page<Piso> findByBloque_IdAndDeletedAtIsNull(UUID bloqueId, Pageable pageable);
    boolean existsByBloque_IdAndNumeroNivelAndDeletedAtIsNull(UUID bloqueId, Integer numeroNivel);
}
