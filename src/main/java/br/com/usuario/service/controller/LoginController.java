package br.com.usuario.service.controller;

import br.com.usuario.service.dto.LoginDTO;
import br.com.usuario.service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO dto) {
        return ResponseEntity.ok(loginService.login(dto));
    }

}