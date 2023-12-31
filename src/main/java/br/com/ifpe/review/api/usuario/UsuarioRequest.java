package br.com.ifpe.review.api.usuario;

import br.com.ifpe.review.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

   private String nome;
  
   private String email;

   private String senha;

   public Usuario build() {

      return Usuario.builder()
            .nome(nome)

            .email(email)

            .senha(senha)

            .build();
   }
}
