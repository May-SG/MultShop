package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.UsuarioDto;
import br.ecommerce.multiShop.exception.ResourceNotFoundException;
import br.ecommerce.multiShop.model.Contato;
import br.ecommerce.multiShop.model.Endereco;
import br.ecommerce.multiShop.model.Usuario;
import br.ecommerce.multiShop.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario findAllByNome(String nome) {
        return repository.findAllByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário com nome '" +nome+ "' não encontrado."));
    }

    @Override
    public Usuario findAllByCpf(String cpf) {
        return repository.findAllByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não encontrado."));
    }

    @Override
    public Usuario findAllByEmail(String email) {
        return repository.findAllByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não encontrado."));
    }

    @Override
    public Usuario salvar(UsuarioDto dto) {
        Usuario usuario = converterDtoParaEntidade(dto);
        return repository.save(usuario);
    }

    @Override
    public Usuario updateNome(UsuarioDto dto) {
        Usuario entidade = converterDtoParaEntidade(dto);
        Usuario usuario = findAllByEmail(entidade.getEmail());
        return null; // repository.savedNome(usuario.getNome());
    }

    public Usuario converterDtoParaEntidade(UsuarioDto dto) {
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
