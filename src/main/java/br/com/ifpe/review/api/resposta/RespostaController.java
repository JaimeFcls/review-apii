package br.com.ifpe.review.api.resposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.review.modelo.comentario.Comentario;
import br.com.ifpe.review.modelo.comentario.ComentarioRepository;
import br.com.ifpe.review.modelo.resposta.Resposta;
import br.com.ifpe.review.modelo.resposta.RespostaService;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;

@RestController
@RequestMapping("/api/respostas")
@CrossOrigin(origins = "https://review-novo-web.vercel.app")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping
    public ResponseEntity<Resposta> save(@RequestBody RespostaRequest request) {
        Resposta resposta = respostaService.save(request.build(usuarioRepository, comentarioRepository));
        return new ResponseEntity<Resposta>(resposta, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Resposta> findAll() {
        return respostaService.findAll();
    }

    @GetMapping("/{id}")
    public Resposta findById(@PathVariable Long id) {

        return respostaService.findById(id);
    }

    @GetMapping("/filme/{id}")
    public List<Resposta> findByMovieId(@PathVariable String id) {

        return respostaService.findByMovieId(id);
    }

    @GetMapping("/serie/{id}")
    public List<Resposta> findBySerieId(@PathVariable String id) {

        return respostaService.findBySerieId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta> update(@PathVariable("id") Long id, @RequestBody RespostaRequest request) {
        Resposta resposta = respostaService.update(id, request.build(usuarioRepository, comentarioRepository));
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        respostaService.delete(id);
        return ResponseEntity.ok().build();
    }
}