package br.com.usuario.service.service;

import br.com.usuario.service.entity.PermissaoEntity;
import br.com.usuario.service.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<PermissaoEntity> salvarTodos(List<PermissaoEntity> entities){
        return this.permissaoRepository.saveAll(entities);
    }

}
