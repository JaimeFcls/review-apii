package br.com.ifpe.review.api.resposta;

import br.com.ifpe.review.modelo.comentario.Comentario;
import br.com.ifpe.review.modelo.comentario.ComentarioRepository;
import br.com.ifpe.review.modelo.resposta.Resposta;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class RespostaRequest {
    private Long usuarioId;
    private Long comentarioId;
    private String movieId;
    private String serieId;
    private String texto;

    public Resposta build(UsuarioRepository usuarioRepository, ComentarioRepository comentarioRepository) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
        Comentario comentario = comentarioRepository.findById(comentarioId).orElse(null);
        return Resposta.builder()
                .texto(texto)
                .usuario(usuario)
                .comentario(comentario)
                .movieId(movieId)
                .serieId(serieId)
                .build();
    }
}
