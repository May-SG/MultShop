package br.ecommerce.multiShop.dto;

import lombok.Data;

@Data
public class AtualizarSenhaDto {

    private String cpf;
    private String email;
    private String senhaAtual;
    private String novaSenha;

}
