package br.com.ifpe.review.api.comentario;

import br.com.ifpe.review.modelo.comentario.Resposta;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioRequest {

    private String comentar;
    private Long usuarioId;
    private String movieId;
    private String serieId;

    public Resposta build(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        return Resposta.builder()
                .comentar(comentar)
                .usuario(usuario)
                .movieId(movieId)
                .serieId(serieId)
                .build();
    }
}
