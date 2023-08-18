package br.com.usuario.service.repository;

import br.com.usuario.service.entity.PrevilegioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevilegioRepository extends JpaRepository<PrevilegioEntity,Long>, RevisionRepository<PrevilegioEntity,Long,Long> {
}
