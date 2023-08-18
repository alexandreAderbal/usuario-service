package br.com.usuario.service.service;

import br.com.usuario.service.entity.UsuarioAutorizacaoEntity;
import br.com.usuario.service.repository.UsuarioAutorizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioAutorizacaoService {

    private final UsuarioAutorizacaoRepository usuarioAutorizacaoRepository;

    @Autowired
    public UsuarioAutorizacaoService(UsuarioAutorizacaoRepository usuarioAutorizacaoRepository) {
        this.usuarioAutorizacaoRepository = usuarioAutorizacaoRepository;
    }

    public List<UsuarioAutorizacaoEntity> salvarTodos(List<UsuarioAutorizacaoEntity> entities){
        return this.usuarioAutorizacaoRepository.saveAll(entities);
    }

    public List<UsuarioAutorizacaoEntity> buscarPorUsuarioId(Long usuarioId){
        return this.usuarioAutorizacaoRepository.findByUsuarioId(usuarioId);
    }

}
