package com.pedro.usuariosservice.service;


import com.pedro.usuariosservice.model.Usuario;
import com.pedro.usuariosservice.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

       @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    @Override
    public Usuario update(Integer id, Usuario usuario) throws Exception {
        Usuario retorno = this.usuarioRepository.findById(id);

        if (retorno == null) {
            throw new Exception("Usuario não existe no banco de dados" + id);
        }

        Usuario usuarioSalvo = retorno;
        BeanUtils.copyProperties(usuario, usuarioSalvo, "id");

        return usuarioRepository.save(usuarioSalvo);
    }

    @Override
    public List<Usuario> findByEmail(String email) {  return usuarioRepository.findByEmail(email);   }

    @Override
    public List<Usuario> findByCpfCnpj(String cpfCnpj) {  return usuarioRepository.findByCpfCnpj(cpfCnpj);   }

    @Override
    public Usuario findById(Integer id) { return usuarioRepository.findById(id);}

    @Override
    public Usuario findByEmailAndSenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email,senha);
    }

    @Override
    public Usuario findByCpfCnpjAndSenha(String cpfCnpj, String senha) {
        return usuarioRepository.findByCpfCnpjAndSenha(cpfCnpj,senha);
    }

}
