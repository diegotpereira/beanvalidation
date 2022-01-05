package br.com.java.beanvalidation.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.java.beanvalidation.entity.UsuarioEntity;



@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger>{
    public UsuarioEntity findTop1ByCpf(String cpf);

    public UsuarioEntity findTop1ByEmail(String email);
}
