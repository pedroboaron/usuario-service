package com.pedro.usuariosservice.controller;

import com.pedro.usuariosservice.event.RecursoCriadoEvent;
import com.pedro.usuariosservice.model.Usuario;
import com.pedro.usuariosservice.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        return ResponseEntity.ok(usuarioService.findByEmailAndSenha(email,senha));
    }

    @GetMapping("/CpfCnpj")
    public ResponseEntity<Usuario> findBycpfCnpj(@RequestParam("cpfCnpj") String cpfCnpj, @RequestParam("senha") String senha) {
        return ResponseEntity.ok(usuarioService.findByCpfCnpjAndSenha(cpfCnpj,senha));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario save = usuarioService.save(usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping
    public ResponseEntity<Usuario> alterarPessoa(@RequestParam("id") Integer id,
                                                 @Valid @RequestBody Usuario usuario,
                                                 HttpServletResponse response) throws Exception {

        Usuario save = this.usuarioService.update(id, usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.ok(save);
    }

    @PatchMapping
    public ResponseEntity<Usuario> alterarPessoa(@RequestParam("id") Integer id,
                                                 @RequestParam("senha") String senha,
                                                 HttpServletResponse response) throws Exception {
        Usuario usuario = this.usuarioService.findById(id);
        usuario.setSenha(senha);
        Usuario save = this.usuarioService.update(id, usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getId()));
        return ResponseEntity.ok(save);
    }
}