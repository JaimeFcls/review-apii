package br.com.ifpe.review.modelo.comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByMovieId(String movieId); 
    List<Comentario> findBySerieId(String serieId);    

}
