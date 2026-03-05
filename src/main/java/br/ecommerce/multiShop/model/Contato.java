package br.ecommerce.multiShop.model;

import br.ecommerce.multiShop.enums.TipoContato;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @OneToOne(optional = false)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_contato_usuario"))
    private Usuario usuario;


    @Column(length = 3)
    private String ddd;

    @Column(length = 20)
    private String telefone;

    @Column(length = 20)
    private String celular;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('PESSOAL','PROFISSIONAL') default 'pessoal'")
    private TipoContato tipo;

}
