package br.ecommerce.multiShop.dto;

import lombok.Data;

@Data
public class AtualizarEmailDto {

    private String cpf;
    private String emailAtual;
    private String novoEmail;

}
