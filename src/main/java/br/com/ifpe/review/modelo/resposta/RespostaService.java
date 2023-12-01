package br.com.ifpe.review.modelo.resposta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.review.api.resposta.RespostaRequest;
import br.com.ifpe.review.modelo.comentario.Comentario;
import br.com.ifpe.review.modelo.comentario.ComentarioRepository;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.modelo.usuario.UsuarioRepository;


@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Resposta criarResposta(RespostaRequest request) {
        // Buscar o usuário e o comentário pelos seus IDs
        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Comentario comentario = comentarioRepository.findById(request.getComentarioId())
            .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));

        // Criar a nova resposta
        Resposta resposta = new Resposta();
        resposta.setUsuario(usuario);
        resposta.setComentario(comentario);
        resposta.setTexto(request.getTexto());

        // Salvar a resposta no banco de dados
        return respostaRepository.save(resposta);
    }

    public List<Resposta> getRespostasPorComentario(Long comentarioId) {
        return respostaRepository.findByComentarioId(comentarioId);
    }
}
