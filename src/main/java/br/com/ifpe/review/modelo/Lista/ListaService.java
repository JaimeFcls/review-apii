package br.com.ifpe.review.modelo.Lista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ifpe.review.api.lista.ListaRequest;
import br.com.ifpe.review.modelo.comentario.Comentario;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    @Transactional
    public Lista save(Lista lista) {
        return listaRepository.save(lista);
    }

    public Lista create(Lista lista) {
        lista.setHabilitado(Boolean.TRUE);
        lista.setVersao(1L);
        lista.setDataCriacao(LocalDate.now());
        return listaRepository.save(lista);
    }

    public List<Lista> findAll() {
        return listaRepository.findAll();
    }
    
    public Lista findById(Long id) {
        return listaRepository.findById(id).orElse(null);
    }

}