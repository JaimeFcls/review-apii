package br.com.ifpe.review.modelo.comentario;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Transactional
    public Resposta save(Resposta comentario) {

        comentario.setHabilitado(Boolean.TRUE);
        comentario.setVersao(1L);
        comentario.setDataCriacao(LocalDate.now());
        return repository.save(comentario);
    }

    public List<Resposta> findAll() {

        return repository.findAll();
    }

    public List<Resposta> findByMovieId(String movieId) {

        return repository.findByMovieId(movieId);
    }

    public List<Resposta> findBySerieId(String serieId) {

        return repository.findBySerieId(serieId);
    }

    @Transactional
    public void update(Long id, Resposta comentarioAlterado) {

        Resposta comentario = repository.findById(id).get();
        comentario.setComentar(comentarioAlterado.getComentar());
        comentario.setUsuario(comentarioAlterado.getUsuario());
        comentario.setVersao(comentario.getVersao() + 1);
        repository.save(comentario);
    }

    @Transactional
    public void delete(Long id) {

        Resposta comentario = repository.findById(id).get();
        comentario.setHabilitado(Boolean.FALSE);
        comentario.setVersao(comentario.getVersao() + 1);
        repository.save(comentario);
    }

}
