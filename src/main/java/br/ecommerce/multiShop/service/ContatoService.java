package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.UsuarioResponseDto;

public interface ContatoService {

    UsuarioResponseDto findByPhone(String celular);

    UsuarioResponseDto findByLandLinePhone(String telefone);

}
