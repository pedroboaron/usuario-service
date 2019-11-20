package com.pedro.usuariosservice.repository;

import com.pedro.usuariosservice.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAll();

    Page<Usuario> findAll(Pageable pageable);

    List<Usuario> findByEmail(String email);

    List<Usuario> findByCpfCnpj(String cpfCnpj);

    Usuario findById(Integer id);

    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByCpfCnpjAndSenha(String cpfCnpj, String senha);
}
