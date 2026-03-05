package br.ecommerce.multiShop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 100, nullable = false)
    private String senha;

    @Column(name = "status_usuario")
    private boolean statusUsuario;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private Contato contato;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario", orphanRemoval = true)
    private Endereco endereco;

}
