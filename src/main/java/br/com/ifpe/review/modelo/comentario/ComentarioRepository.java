package br.com.ifpe.review.modelo.comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Resposta, Long> {

    List<Resposta> findByMovieId(String movieId);

    List<Resposta> findBySerieId(String serieId);

}
