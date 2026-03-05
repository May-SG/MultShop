package br.ecommerce.multiShop.dto;

import br.ecommerce.multiShop.model.Usuario;
import lombok.Data;

@Data
public class UsuarioDto {

    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private EnderecoDto endereco;
    private ContatoDto contato;

    public UsuarioDto() {}
    public UsuarioDto(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.email = usuario.getEmail();
    }

}
