package br.com.ifpe.review.modelo.resposta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Where;

import br.com.ifpe.review.modelo.comentario.Comentario;
import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Resposta")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resposta extends EntidadeAuditavel {
    
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "comentario_id")
    private Comentario comentario;

    @NotBlank
    @Column(length = 1500)
    private String texto;

    @Column
    private String movieId;

    @Column
    private String serieId;
}
