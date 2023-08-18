package br.com.usuario.service.repository;

import br.com.usuario.service.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long>, RevisionRepository<UsuarioEntity,Long,Long> {
    Optional<UsuarioEntity> findByEmail(String username);
}
