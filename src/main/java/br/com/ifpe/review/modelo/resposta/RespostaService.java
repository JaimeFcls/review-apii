package br.com.ifpe.review.modelo.resposta;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository repository;

    @Transactional
    public Resposta save(Resposta resposta) {

        resposta.setHabilitado(Boolean.TRUE);
        resposta.setVersao(1L);
        resposta.setDataCriacao(LocalDate.now());
        return repository.save(resposta);
    }

    public List<Resposta> findAll() {

        return repository.findAll();
    }

    public Resposta findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Resposta> findByMovieId(String movieId) {

        return repository.findByMovieId(movieId);
    }

    public List<Resposta> findBySerieId(String serieId) {

        return repository.findBySerieId(serieId);
    }

    @Transactional
    public Resposta update(Long id, Resposta repostaAlterada) {
        Resposta resposta = repository.findById(id).get();
        resposta.setTexto(repostaAlterada.getTexto());
        resposta.setUsuario(repostaAlterada.getUsuario());
        resposta.setVersao(resposta.getVersao() + 1);
        return repository.save(resposta);
    }
    @Transactional
    public void delete(Long id) {

        Resposta resposta = repository.findById(id).get();
        resposta.setHabilitado(Boolean.FALSE);
        resposta.setVersao(resposta.getVersao() + 1);
        repository.save(resposta);
    }

}
