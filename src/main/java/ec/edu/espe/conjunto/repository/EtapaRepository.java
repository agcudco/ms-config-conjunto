package ec.edu.espe.conjunto.repository;

import ec.edu.espe.conjunto.entity.Etapa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, UUID> {

    Optional<Etapa> findByIdAndDeletedAtIsNull(UUID id);
    Page<Etapa> findByConjunto_IdAndDeletedAtIsNull(UUID conjuntoId, Pageable pageable);
    boolean existsByConjunto_IdAndCodigoIgnoreCaseAndDeletedAtIsNull(UUID conjuntoId, String codigo);
}
