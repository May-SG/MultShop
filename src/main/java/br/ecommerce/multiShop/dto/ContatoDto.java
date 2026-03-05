package br.ecommerce.multiShop.dto;

import br.ecommerce.multiShop.enums.TipoContato;
import lombok.Data;

@Data
public class ContatoDto {

    private String ddd;
    private String telefone;
    private String celular;
    private TipoContato tipo;

}
