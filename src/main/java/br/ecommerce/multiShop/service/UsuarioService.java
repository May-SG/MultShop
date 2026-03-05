package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.*;
import br.ecommerce.multiShop.model.Usuario;

public interface UsuarioService {

    UsuarioResponseDto findAllByNome(String usuario);

    UsuarioResponseDto findAllByCpf(String cpf);

    UsuarioResponseDto findAllByEmail(String email);

    UsuarioResponseDto salvar(UsuarioRequestDto dto);

    String atualizarNome(AtualizarNomeDto dto);

    String atualizarEmail(AtualizarEmailDto dto);

    String atualizarSenha(AtualizarSenhaDto dto);

    String desativarUsusario(UsuarioRequestDto dto);

}
