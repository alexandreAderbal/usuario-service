package br.com.usuario.service.repository;

import br.com.usuario.service.entity.PermissaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<PermissaoEntity,Long>, RevisionRepository<PermissaoEntity,Long,Long> {
}
