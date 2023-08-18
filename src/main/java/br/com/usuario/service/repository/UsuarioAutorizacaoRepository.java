package br.com.usuario.service.repository;

import br.com.usuario.service.entity.UsuarioAutorizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAutorizacaoRepository extends JpaRepository<UsuarioAutorizacaoEntity,Long>, RevisionRepository<UsuarioAutorizacaoEntity,Long,Long> {
    List<UsuarioAutorizacaoEntity> findByUsuarioId(Long usuarioId);
}
