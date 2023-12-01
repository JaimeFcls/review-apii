package br.com.ifpe.review.modelo.resposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    List<Resposta> findByComentarioId(Long comentarioId);

    List<Resposta> findByMovieId(String movieId);

    List<Resposta> findBySerieId(String serieId);
}