package br.com.java.service;

import org.springframework.stereotype.Service;

import br.com.java.entity.UsuarioEntity;

@Service
public interface UsuarioService {
    
    public UsuarioEntity criar(UsuarioEntity usuarioEntity) throws Exception;
}
