package br.com.java.beanvalidation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.beanvalidation.entity.UsuarioEntity;
import br.com.java.beanvalidation.repository.UsuarioRepository;
import br.com.java.beanvalidation.service.UsuarioService;

import static java.util.Objects.nonNull;

import java.math.BigInteger;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioEntity criar(UsuarioEntity usuarioEntity) throws Exception{
        

        try {
            if (nonNull(usuarioRepository.findTop1ByCpf(usuarioEntity.getCpf()))) {
                
                throw new Exception("O cpf inserido já pertence a outro usuário.");
            }

            if (nonNull(usuarioRepository.findTop1ByEmail(usuarioEntity.getEmail()))) {
                
                throw new Exception("O E-mail inserido já pertence a outro usuário.");
            }

            return usuarioRepository.save(usuarioEntity);
        } catch (Exception e) {
            
        }
        return null;
    }

    @Override
    public void deletar(BigInteger idUsuario) throws Exception {
        // TODO Auto-generated method stub
        this.buscarPorId(idUsuario);
        this.usuarioRepository.deleteById(idUsuario);
        
    }

    @Override
    @Transactional
    public UsuarioEntity editar(UsuarioEntity usuarioEntity) {
        // TODO Auto-generated method stub
        return this.usuarioRepository.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity buscarPorId(BigInteger idUsuario) throws Exception {
        // TODO Auto-generated method stub
        Optional.ofNullable(idUsuario)
                .orElseThrow(() -> new Exception("Id não pode ser nulo"));
                
        return this.usuarioRepository.findById(idUsuario)
                                     .orElseThrow(() -> new Exception("Cliente de id " + idUsuario + " não encontrado"));
    }
    
}
