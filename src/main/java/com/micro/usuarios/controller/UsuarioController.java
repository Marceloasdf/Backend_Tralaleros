package com.micro.usuarios.controller;

import com.micro.usuarios.dto.LoginDTO;
import com.micro.usuarios.dto.UsuarioDTO;
import com.micro.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public String registrar(@RequestBody UsuarioDTO dto) {
        return service.registrar(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return service.login(dto);
    }
}
