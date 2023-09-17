package br.com.ifpe.review.api.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {

   @Autowired
   private UsuarioService clienteService;

   @PostMapping
   public ResponseEntity<Usuario> save(@RequestBody UsuarioRequest request) {

       Usuario usuario = clienteService.save(request.build());
       return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
  
   }}