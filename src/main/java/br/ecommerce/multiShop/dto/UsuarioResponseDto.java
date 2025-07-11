package br.ecommerce.multiShop.dto;

import lombok.Data;

@Data
public class UsuarioResponseDto {

    private String nome;
    private String email;
    private String cpf;
    private ContatoDto contato;
    private EnderecoDto endereco;

    public UsuarioResponseDto(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public UsuarioResponseDto() {}

}
