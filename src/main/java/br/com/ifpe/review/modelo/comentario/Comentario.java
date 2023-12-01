package br.com.ifpe.review.modelo.comentario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Where;

import br.com.ifpe.review.modelo.usuario.Usuario;
import br.com.ifpe.review.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comentario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comentario extends EntidadeAuditavel {
    @NotBlank
    @Column(length = 1500)
    private String comentar;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column
    private String movieId;

    @Column
    private String serieId;

}
