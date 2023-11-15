package br.com.ifpe.review.modelo.comentario;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

   @Autowired
   private ComentarioRepository repository;
   

   @Transactional
   public Comentario save(Comentario comentario) {

       comentario.setHabilitado(Boolean.TRUE);
       comentario.setVersao(1L);
       comentario.setDataCriacao(LocalDate.now());
       return repository.save(comentario);
   }
   
   public List<Comentario> findAll() {

       return repository.findAll();
   }

   public List<Comentario> findByMovieId(String movieId) {

       // Recupere todos os comentários para o filme específico
       return repository.findByMovieId(movieId);
   }

   @Transactional
   public void update(Long id, Comentario comentarioAlterado) {

       Comentario comentario = repository.findById(id).get();
       comentario.setComentar(comentarioAlterado.getComentar());
       comentario.setUsuario(comentarioAlterado.getUsuario());
       comentario.setVersao(comentario.getVersao() + 1);
       repository.save(comentario);
   }

   @Transactional
   public void delete(Long id) {

       Comentario comentario = repository.findById(id).get();
       comentario.setHabilitado(Boolean.FALSE);
       comentario.setVersao(comentario.getVersao() + 1);

       repository.save(comentario);
   }

}
