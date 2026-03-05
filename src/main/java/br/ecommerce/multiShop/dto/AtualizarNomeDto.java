package br.ecommerce.multiShop.dto;

import lombok.Data;

@Data
public class AtualizarNomeDto {

    private String cpf;
    private String email;
    private String novoNome;

}
