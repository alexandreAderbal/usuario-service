package br.com.usuario.service.service;


import br.com.usuario.service.dto.UsuarioDetailDTO;
import br.com.usuario.service.entity.UsuarioAutorizacaoEntity;
import br.com.usuario.service.entity.UsuarioEntity;
import br.com.usuario.service.repository.UsuarioAutorizacaoRepository;
import br.com.usuario.service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UsuarioDetailsService  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutorizacaoRepository usuarioAutorizacaoRepository;

    @Override
    public UsuarioDetailDTO loadUserByUsername(String email) throws UsernameNotFoundException {
        try {

            UsuarioEntity entity = usuarioRepository.findByEmail(email).orElseThrow(() -> new Exception("user Not found "));

            List<UsuarioAutorizacaoEntity> autorizacaoEntities = usuarioAutorizacaoRepository.findByUsuarioId(entity.getId());

            return UsuarioDetailDTO.builder()
                .username(entity.getEmail())
                .password(entity.getSenha())
                .authorities(getAuthorities(autorizacaoEntities))
                .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<UsuarioAutorizacaoEntity> autorizacaoEntities) {
        return getGrantedAuthorities(getPrivileges(autorizacaoEntities));
    }

    private List<String> getPrivileges(List<UsuarioAutorizacaoEntity> autorizacaoEntities) {

        List<String> privileges = new ArrayList<>();
        for (UsuarioAutorizacaoEntity autorizacao : autorizacaoEntities) {
            privileges.add(
                autorizacao.getPermissao().getNome().concat("_").concat( autorizacao.getPrevilegio().getNome())
            );
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(privileges != null) {
            authorities.addAll(
                    privileges.stream().map(SimpleGrantedAuthority::new).toList()
            );
        }
        return authorities;
    }

}