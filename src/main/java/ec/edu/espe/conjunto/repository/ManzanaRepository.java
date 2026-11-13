package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Manzana;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ManzanaRepository extends JpaRepository<Manzana, UUID> {

    Optional<Manzana> findByIdAndDeletedAtIsNull(UUID id);
    Page<Manzana> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    Page<Manzana> findByEtapa_IdAndDeletedAtIsNull(UUID etapaId, Pageable pageable);
    Page<Manzana> findByConjunto_IdAndEtapaIsNullAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
