package br.com.ifpe.review.api.resposta;

public class RespostaRequest {
    private Long usuarioId;
    private Long comentarioId;
    private String texto;

    // getters e setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Long comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}