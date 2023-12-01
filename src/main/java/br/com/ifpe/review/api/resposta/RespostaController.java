package br.com.ifpe.review.api.resposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.review.modelo.resposta.Resposta;
import br.com.ifpe.review.modelo.resposta.RespostaService;

@RestController
@RequestMapping("/api/respostas")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RespostaController {
    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public Resposta criarResposta(@RequestBody RespostaRequest request) {
        return respostaService.criarResposta(request);
    }

    @GetMapping("/{comentarioId}")
    public List<Resposta> getRespostasPorComentario(@PathVariable Long comentarioId) {
        return respostaService.getRespostasPorComentario(comentarioId);
    }
}