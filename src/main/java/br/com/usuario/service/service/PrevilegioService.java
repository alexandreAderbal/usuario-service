package br.com.usuario.service.service;

import br.com.usuario.service.entity.PrevilegioEntity;
import br.com.usuario.service.repository.PrevilegioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevilegioService {

    @Autowired
    private PrevilegioRepository previlegioRepository;

    public List<PrevilegioEntity> salvarTodos(List<PrevilegioEntity> entities){
        return this.previlegioRepository.saveAll(entities);
    }

}
