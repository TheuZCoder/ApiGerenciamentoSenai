package matheus.api.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "usuario")

@Entity
public class Usuario {

    @Id
    private Integer cpf_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
}
