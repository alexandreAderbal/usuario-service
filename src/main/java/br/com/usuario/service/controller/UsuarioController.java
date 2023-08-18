package br.com.usuario.service.controller;

import br.com.usuario.service.dto.UsuarioDTO;
import br.com.usuario.service.entity.UsuarioEntity;
import br.com.usuario.service.service.UsuarioService;
import br.com.usuario.service.constants.OpenApiConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.usuario.service.constants.PermissaoConstants.*;
import static br.com.usuario.service.converter.UsuarioConverter.*;

@RestController
@RequestMapping(value = "usuario")
@SecurityRequirement(name = OpenApiConstants.BEARER_AUTH)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Secured(USUARIO_GRAVAR)
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto) throws Exception {
        return ResponseEntity.ok(
            entityToDTO(
                this.usuarioService.salvar(dtoToEntity(dto))
            )
        );
    }

    @PutMapping("/{id}")
    @Secured(USUARIO_ALTERAR)
    public ResponseEntity<UsuarioDTO> alterar(@RequestBody UsuarioDTO dto, @PathVariable Long id) throws Exception {
        UsuarioEntity entity = dtoToEntity(dto);
        entity.setId(id);
        return ResponseEntity.ok(
            entityToDTO(
                this.usuarioService.altera(entity)
            )
        );
    }

    @GetMapping("/{id}")
    @Secured(USUARIO_LER)
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(
            entityToDTO(
                this.usuarioService.buscarPorId(id)
            )
        );
    }

    @GetMapping
    @Secured(USUARIO_LER)
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() throws Exception {
        return ResponseEntity.ok(
            dtoList(
                this.usuarioService.buscarTodos()
            )
        );
    }

    @DeleteMapping("/{id}")
    @Secured(USUARIO_DELETAR)
    public ResponseEntity<HttpStatus> deletarPorId(@PathVariable Long id) throws Exception {
        this.usuarioService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }

}
