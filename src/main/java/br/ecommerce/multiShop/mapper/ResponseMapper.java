package br.ecommerce.multiShop.mapper;

import br.ecommerce.multiShop.dto.ContatoDto;
import br.ecommerce.multiShop.dto.EnderecoDto;
import br.ecommerce.multiShop.dto.UsuarioRequestDto;
import br.ecommerce.multiShop.dto.UsuarioResponseDto;
import br.ecommerce.multiShop.model.Contato;
import br.ecommerce.multiShop.model.Endereco;
import br.ecommerce.multiShop.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    public UsuarioResponseDto toResponseDto(Usuario usuario) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setEmail(usuario.getEmail());

        ContatoDto contatoDto = new ContatoDto();
        contatoDto.setDdd(usuario.getContato().getDdd());
        contatoDto.setTelefone(usuario.getContato().getTelefone());
        contatoDto.setCelular(usuario.getContato().getCelular());
        contatoDto.setTipo(usuario.getContato().getTipo());

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setLogradouro(usuario.getEndereco().getLogradouro());
        enderecoDto.setNumero(usuario.getEndereco().getNumero());
        enderecoDto.setComplemento(usuario.getEndereco().getComplemento());
        enderecoDto.setBairro(usuario.getEndereco().getBairro());
        enderecoDto.setCidade(usuario.getEndereco().getCidade());
        enderecoDto.setEstado(usuario.getEndereco().getEstado());
        enderecoDto.setCep(usuario.getEndereco().getCep());

        dto.setContato(contatoDto);
        dto.setEndereco(enderecoDto);

        return dto;
    }

    public Usuario converterDtoParaEntidade(UsuarioRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setSenha(dto.getSenha());
        usuario.setEmail(dto.getEmail());
        usuario.setStatusUsuario(true);

        Contato contato = new Contato();
        contato.setDdd(dto.getContato().getDdd());
        contato.setCelular(dto.getContato().getCelular());
        contato.setTelefone(dto.getContato().getTelefone());
        contato.setTipo(dto.getContato().getTipo());
        contato.setUsuario(usuario);

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getEndereco().getLogradouro());
        endereco.setNumero(dto.getEndereco().getNumero());
        endereco.setComplemento(dto.getEndereco().getComplemento());
        endereco.setBairro(dto.getEndereco().getBairro());
        endereco.setCidade(dto.getEndereco().getCidade());
        endereco.setEstado(dto.getEndereco().getEstado());
        endereco.setCep(dto.getEndereco().getCep());
        endereco.setUsuario(usuario);

        usuario.setContato(contato);
        usuario.setEndereco(endereco);

        return usuario;
    }

}
