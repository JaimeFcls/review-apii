package br.com.ifpe.review.modelo.usuario;

import javax.transaction.Transactional;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository repository;

   @Transactional
   public Usuario save(Usuario usuario) {

       usuario.setHabilitado(Boolean.TRUE);
       usuario.setVersao(1L);
       usuario.setDataCriacao(LocalDate.now());
       return repository.save(usuario);
   }

}