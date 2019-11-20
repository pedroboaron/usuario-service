package com.pedro.usuariosservice.service;

import com.pedro.usuariosservice.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> findAll();

    Page<Usuario> findAll(Pageable pageable);

    Usuario save(Usuario cartao);

    Usuario update(Integer id, Usuario usuario) throws Exception;

    Usuario findByEmail(String email);

    Usuario findByCpfCnpj(String cpfCnpj);

    void deleteById(Integer id);

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByCpfCnpjAndSenha(String cpfCnpj, String senha);

    Usuario findById(Integer id);
}
