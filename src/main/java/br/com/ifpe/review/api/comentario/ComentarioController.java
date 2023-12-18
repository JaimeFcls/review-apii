package br.com.ifpe.review.api.comentario;

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
import br.com.ifpe.review.modelo.comentario.ComentarioService;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;

@RestController
@RequestMapping("/api/comentar")
@CrossOrigin(origins = "https://review-novo-web.vercel.app" )
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

   

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Comentario> save(@RequestBody ComentarioRequest request) {
        Comentario comentario = comentarioService.save(request.build(usuarioRepository));
        return new ResponseEntity<Comentario>(comentario, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }
   @GetMapping("/{id}")
    public Comentario findById(@PathVariable Long id) {

        return comentarioService.findById(id);
    }

    @GetMapping("/filme/{id}")
    public List<Comentario> findByMovieId(@PathVariable String id) {

        return comentarioService.findByMovieId(id);
    }

    @GetMapping("/serie/{id}")
    public List<Comentario> findBySerieId(@PathVariable String id) {

        return comentarioService.findBySerieId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> update(@PathVariable("id") Long id, @RequestBody ComentarioRequest request) {
        comentarioService.update(id, request.build(usuarioRepository));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        comentarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}