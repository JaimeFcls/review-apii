package br.com.ifpe.review.modelo.resposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    List<Resposta> findByMovieId(String movieId);

    List<Resposta> findBySerieId(String serieId);
}
