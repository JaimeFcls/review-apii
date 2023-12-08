package br.com.ifpe.review.modelo.Lista;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    @Transactional
    public Lista save(Lista lista) {
        lista.setHabilitado(Boolean.TRUE);
        lista.setVersao(1L);
        lista.setDataCriacao(LocalDate.now());
        return listaRepository.save(lista);
    }

    public Lista create(Lista lista) {
        lista.setHabilitado(Boolean.TRUE); // Adicione esta linha
        return listaRepository.save(lista);
    }

    public List<Lista> findAll() {
        return listaRepository.findAll();
    }
    
    public Lista findById(Long id) {
        return listaRepository.findById(id).orElse(null);
    }
}
