package br.com.java.beanvalidation.service;

import org.springframework.stereotype.Service;

import br.com.java.beanvalidation.entity.UsuarioEntity;



@Service
public interface UsuarioService {
    
    public UsuarioEntity criar(UsuarioEntity usuarioEntity) throws Exception;
}
