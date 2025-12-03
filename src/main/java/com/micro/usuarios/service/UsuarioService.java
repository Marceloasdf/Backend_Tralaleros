package com.micro.usuarios.service;

import com.micro.usuarios.dto.LoginDTO;
import com.micro.usuarios.dto.UsuarioDTO;
import com.micro.usuarios.model.Usuario;
import com.micro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public String registrar(UsuarioDTO dto) {

        if (repo.findByEmail(dto.getEmail()).isPresent()) {
            return "El correo ya está registrado.";
        }

        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword()); 

        repo.save(u);
        return "Usuario registrado correctamente.";
    }

    public String login(LoginDTO dto) {
        return repo.findByEmail(dto.getEmail())
                .map(u -> u.getPassword().equals(dto.getPassword()) ?
                        "Login correcto" :
                        "Contraseña incorrecta")
                .orElse("Usuario no encontrado");
    }
}
