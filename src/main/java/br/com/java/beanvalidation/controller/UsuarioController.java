package br.com.java.beanvalidation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.java.beanvalidation.entity.UsuarioEntity;
import br.com.java.beanvalidation.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@Slf4j
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    

    @PostMapping(path = "",produces = "application/json")
    public ResponseEntity criarNovoUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {

        log.debug("Iniciando Método.");

        try {
            usuarioService.criar( usuarioEntity );

            return ResponseEntity.ok(usuarioEntity);
        }catch (Exception ee) {
            log.debug("Erro durante o Salvamento do novo usuario.");
            return ResponseEntity.badRequest().body(ee.getMessage());
        }
    }
    @GetMapping(path = "/{idUsuario}", produces = "application/json")
    public ResponseEntity buscarUsuarioPorId(@PathVariable("idUsuario") BigInteger idUsuario) {

        try {
            UsuarioEntity usuarioEntity = usuarioService.buscarPorId(idUsuario);

            return ResponseEntity.ok(usuarioEntity);
        } catch (Exception e) {
            //TODO: handle exception

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping(path = "/{idUsuario}", produces = "application/json")
    public ResponseEntity deletarPorId(@PathVariable ("idUsuario") BigInteger idUsuario) {

        try {
            usuarioService.deletar(idUsuario);

            return ResponseEntity.ok(null);
        } catch (Exception e) {
            //TODO: handle exception

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping(path = "", produces = "application/json")
    public ResponseEntity editarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {
        log.debug("Iniciando o método");

        try {
            usuarioService.editar(usuarioEntity);

            return ResponseEntity.ok(usuarioEntity);
        } catch (Exception e) {
            //TODO: handle exception

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
