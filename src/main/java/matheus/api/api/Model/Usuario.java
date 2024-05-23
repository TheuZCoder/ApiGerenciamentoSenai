package matheus.api.api.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(length = 11, nullable = false)
    private Long cpf_usuario;

    @Column(length = 35, nullable = false)
    private String nome_usuario;

    @Column(length = 35, nullable = false)
    private String email_usuario;

    @Column(length = 22, nullable = false)
    private String senha_usuario;
}
