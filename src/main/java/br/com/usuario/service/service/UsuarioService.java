package br.com.usuario.service.service;

import br.com.usuario.service.entity.UsuarioEntity;
import br.com.usuario.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.usuario.service.util.CryptographyUtil.bcryptEncoder;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity buscarPorId(Long id) throws Exception {
        return usuarioRepository.findById(id)
            .orElseThrow(()-> new Exception("não encontramos o usuario com o id: "+id));
    }

    public List<UsuarioEntity> buscarTodos() throws Exception {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity salvar(UsuarioEntity entity) throws Exception {
        entity.setSenha(bcryptEncoder(entity.getSenha()));
        return usuarioRepository.save(entity);
    }

    public UsuarioEntity altera(UsuarioEntity usuario) throws Exception {
        this.buscarPorId(usuario.getId());
        return usuarioRepository.save(usuario);
    }

    public void deletarPorId(Long id) throws Exception {
        this.buscarPorId(id);
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity buscarPorEmail(String email) throws Exception {
        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
