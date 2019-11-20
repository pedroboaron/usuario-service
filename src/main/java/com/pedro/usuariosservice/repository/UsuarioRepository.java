package com.pedro.usuariosservice.repository;

import com.pedro.usuariosservice.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll();

    Page<Usuario> findAll(Pageable pageable);

    Usuario findByEmail(String email);

    Usuario findByCpfCnpj(String cpfCnpj);

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByCpfCnpjAndSenha(String cpfCnpj, String senha);
}
