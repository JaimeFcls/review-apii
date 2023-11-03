package br.com.ifpe.review.modelo.usuario;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository repository;
   
   public Usuario autenticar(String email, String senha) {
       // Busca o usuário pelo email
       Usuario usuario = repository.findByEmail(email);

       // Verifica se o usuário existe e a senha está correta
       if (usuario != null && usuario.getSenha().equals(senha)) {
           return usuario; // Autenticação bem-sucedida
       }

       return null; // Autenticação falhou
   }

   @Transactional
   public Usuario save(Usuario usuario) {

       usuario.setHabilitado(Boolean.TRUE);
       usuario.setVersao(1L);
       usuario.setDataCriacao(LocalDate.now());
       return repository.save(usuario);
   }
   
   public List<Usuario> findAll() {

       return repository.findAll();
   }

   public Usuario findById(Long id) {

       return repository.findById(id).get();
   }

   @Transactional
   public void update(Long id, Usuario usuarioAlterado) {

       Usuario usuario = repository.findById(id).get();
       usuario.setNome(usuarioAlterado.getNome());
       usuario.setEmail(usuarioAlterado.getEmail());
       usuario.setSenha(usuarioAlterado.getSenha());
    
       usuario.setVersao(usuario.getVersao() + 1);
       repository.save(usuario);
   }

   @Transactional
   public void delete(Long id) {

       Usuario usuario = repository.findById(id).get();
       usuario.setHabilitado(Boolean.FALSE);
       usuario.setVersao(usuario.getVersao() + 1);

       repository.save(usuario);
   }

}
