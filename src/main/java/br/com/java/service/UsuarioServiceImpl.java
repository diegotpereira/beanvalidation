package br.com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.java.entity.UsuarioEntity;
import br.com.java.repository.UsuarioRepository;
import static java.util.Objects.nonNull;

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

            if (nonNull(usuarioRepository.findTop1ByEmail(usuarioEntity.getCpf()))) {
                
                throw new Exception("O E-mail inserido já pertence a outro usuário.");
            }

            return usuarioRepository.save(usuarioEntity);
        } catch (Exception e) {
            
        }
        return null;
    }
    
}
