package br.com.ifpe.review.api.usuario;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "https://review-novo-web.vercel.app")
public class UsuarioController {

   @Autowired
   private UsuarioService usuarioService;
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam String email, @RequestParam String senha) {
        Usuario usuario = usuarioService.autenticar(email, senha);
        
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UsuarioRequest request) {
        try {
            Usuario usuario = usuarioService.save(request.build());
            return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
        } catch (Exception e) {
            
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
   @GetMapping
    public List<Usuario> findAll() {
  
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {

        return usuarioService.findById(id);
    }
    @PutMapping("/{id}")
   public ResponseEntity<Usuario> update(@PathVariable("id") Long id, @RequestBody UsuarioRequest request) {

       usuarioService.update(id, request.build());
       return ResponseEntity.ok().build();
   }
  @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       usuarioService.delete(id);
       return ResponseEntity.ok().build();
   }
}