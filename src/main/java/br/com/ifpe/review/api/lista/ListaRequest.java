package br.com.ifpe.review.api.lista;

import br.com.ifpe.review.modelo.Lista.Lista;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaRequest {

    private String movieId;
    private String serieId;
    private Long usuarioId;

    
    public Lista build(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        return Lista.builder()
                .movieId(movieId)
                .serieId(serieId)
                .usuario(usuario)
                .build();
    }

}