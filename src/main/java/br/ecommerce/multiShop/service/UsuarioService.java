package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.UsuarioDto;
import br.ecommerce.multiShop.model.Usuario;

public interface UsuarioService {

    Usuario findAllByNome(String usuario);

    Usuario findAllByCpf(String cpf);

    Usuario findAllByEmail(String email);

    Usuario salvar(UsuarioDto dto);

    Usuario updateNome(UsuarioDto dto);

}
