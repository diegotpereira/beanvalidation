package br.com.java.beanvalidation.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import br.com.java.beanvalidation.entity.UsuarioEntity;



@Service
public interface UsuarioService {
    
    public UsuarioEntity criar(UsuarioEntity usuarioEntity) throws Exception;

    public void deletar (BigInteger idUsuario) throws Exception;

    public UsuarioEntity editar(UsuarioEntity usuarioEntity);

    public UsuarioEntity buscarPorId(BigInteger idUsuario) throws Exception;
}
