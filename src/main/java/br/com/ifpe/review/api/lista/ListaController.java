package br.com.ifpe.review.api.lista;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifpe.review.modelo.Lista.Lista;
import br.com.ifpe.review.modelo.Lista.ListaService;
//import br.com.ifpe.review.modelo.comentario.Comentario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;

@RestController
@RequestMapping("/api/lista")
@CrossOrigin(origins = "https://921e-201-76-103-38.ngrok-free.app")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    public ResponseEntity<Lista> create(@RequestBody ListaRequest request) {
    Lista lista = listaService.create(request.build(usuarioRepository));
    return new ResponseEntity<Lista>(lista, HttpStatus.CREATED);
}
  
    @GetMapping
    public List<Lista> findAll() {
        return listaService.findAll();
    }
    @GetMapping("/{id}")
    public Lista findById(@PathVariable Long id) {

        return listaService.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        listaService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}