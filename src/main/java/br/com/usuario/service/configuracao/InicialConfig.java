package br.com.usuario.service.configuracao;

import br.com.usuario.service.entity.PermissaoEntity;
import br.com.usuario.service.entity.PrevilegioEntity;
import br.com.usuario.service.entity.UsuarioAutorizacaoEntity;
import br.com.usuario.service.entity.UsuarioEntity;
import br.com.usuario.service.enums.PermissaoEnum;
import br.com.usuario.service.enums.PrevilegioEnum;
import br.com.usuario.service.service.PermissaoService;
import br.com.usuario.service.service.PrevilegioService;
import br.com.usuario.service.service.UsuarioAutorizacaoService;
import br.com.usuario.service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InicialConfig {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PermissaoService permissaoService;
    @Autowired
    private PrevilegioService previlegioService;
    @Autowired
    private UsuarioAutorizacaoService usuarioAutorizacaoService;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        criarUsuarioAdmin();
    }

    @Value("${seguranca.admin.email}")
    private String adminEmail;

    @Value("${seguranca.admin.nome}")
    private String adminNome;

    @Value("${seguranca.admin.senha}")
    private String adminSenha;

    private void criarUsuarioAdmin(){
        try {
            if(usuarioService.buscarPorEmail(adminEmail) == null){
                UsuarioEntity usuario = criarUsuario();
//                List<PrevilegioEntity> previlegios = criarPrevilegios();
//                List<PermissaoEntity> premissoes = criarPermissao(previlegios);
//                criarAutorizacoes(usuario,premissoes);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UsuarioEntity criarUsuario() throws Exception {
        UsuarioEntity entity =
            UsuarioEntity.builder()
                .email(adminEmail)
                .nome(adminNome)
                .senha(adminSenha)
                .build();

      return  usuarioService.salvar(entity);
    }

    private List<PrevilegioEntity> criarPrevilegios(){
        List<PrevilegioEntity> entities = new ArrayList<PrevilegioEntity>();
        PrevilegioEnum.getValues().forEach(
            item -> {
                entities.add(
                    PrevilegioEntity.builder()
                        .nome(item.toString())
                        .build()
                );
            }
        );

        return previlegioService.salvarTodos(entities);
    }

    private List<PermissaoEntity> criarPermissao(List<PrevilegioEntity> previlegios){
        List<PermissaoEntity> entities = new ArrayList<PermissaoEntity>();
        PermissaoEnum.getValues().forEach(
            item -> {
                entities.add(
                    PermissaoEntity.builder()
                        .nome(item.toString())
                        .previlegios(previlegios)
                        .build()
                );
            }
        );

        return permissaoService.salvarTodos(entities);
    }

    private void criarAutorizacoes( UsuarioEntity usuario, List<PermissaoEntity> premissoes ){

        premissoes.forEach(permissao -> {
            List<UsuarioAutorizacaoEntity> list =
                permissao.getPrevilegios().stream().map(
                    previlegio ->
                        UsuarioAutorizacaoEntity.builder()
                            .usuario(usuario)
                            .previlegio(previlegio)
                            .permissao(permissao)
                            .build()
                ).toList();
            usuarioAutorizacaoService.salvarTodos(list);
        } );
    }
}
