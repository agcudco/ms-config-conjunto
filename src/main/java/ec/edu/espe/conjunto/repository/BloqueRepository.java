package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Bloque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, UUID> {

    Optional<Bloque> findByIdAndDeletedAtIsNull(UUID id);
    Page<Bloque> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    Page<Bloque> findByManzana_IdAndDeletedAtIsNull(UUID manzanaId, Pageable pageable);
    Page<Bloque> findByEtapa_IdAndDeletedAtIsNull(UUID etapaId, Pageable pageable);
    Page<Bloque> findByConjunto_IdAndManzanaIsNullAndEtapaIsNullAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
