package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.*;
import br.ecommerce.multiShop.exception.ResourceNotFoundException;
import br.ecommerce.multiShop.mapper.ResponseMapper;
import br.ecommerce.multiShop.model.Contato;
import br.ecommerce.multiShop.model.Endereco;
import br.ecommerce.multiShop.model.Usuario;
import br.ecommerce.multiShop.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UsuarioRepository repository;
    private final ResponseMapper mapper;
    public UsuarioServiceImpl(UsuarioRepository repository, ResponseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioResponseDto findAllByNome(String nome) {
        Usuario usuario = repository.findAllByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário com nome '" +nome+ "' não encontrado."));
        return mapper.toResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto findAllByCpf(String cpf) {
        Usuario usuario = repository.findAllByCpf(cpf)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não encontrado."));
        return mapper.toResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto findAllByEmail(String email) {
        Usuario usuario = repository.findAllByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não encontrado."));
        return mapper.toResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto salvar(UsuarioRequestDto dto) {
        Usuario usuario = mapper.converterDtoParaEntidade(dto);
        Usuario salvo = repository.save(usuario);
        return mapper.toResponseDto(salvo);
    }

    @Override
    public String atualizarNome(AtualizarNomeDto dto) {
        Optional<Usuario> optUsuario =
                repository.findByEmailAndCpf(dto.getEmail(), dto.getCpf());
        if(optUsuario.isEmpty()) {
            return "Usuário não encontrado.";
        }
        Usuario usuario = optUsuario.get();
        usuario.setNome(dto.getNovoNome());
        repository.save(usuario);
        return "Nome atualizado com sucesso.";
    }

    @Override
    public String atualizarEmail(AtualizarEmailDto dto) {
        if (!bancoAtivo()) {
            return "Banco de dados está indisponível no momento.";
        }

        Optional<Usuario> optUsuario =
                repository.findByEmailAndCpf(dto.getEmailAtual(), dto.getCpf());
        if (optUsuario.isEmpty()) {
            return "Erro ao salvar usuário.";
        }

        Usuario usuario = optUsuario.get();
        usuario.setEmail(dto.getNovoEmail());
        repository.save(usuario);
        return "E-mail atualizado com sucesso.";
    }

    @Override
    public String atualizarSenha(AtualizarSenhaDto dto) {
        if (!bancoAtivo()) {
            return "Banco de dados está indisponível no momento.";
        }

        Optional<Usuario> optUsuario =
                repository.findByEmailAndCpf(dto.getEmail(), dto.getCpf());
        if (optUsuario.isEmpty()) {
            return "Erro ao salvar usuário.";
        }

        Usuario usuario = optUsuario.get();
        usuario.setSenha(dto.getNovaSenha());
        repository.save(usuario);
        return "Senha atualizado com sucesso.";
    }

    @Override
    public String desativarUsusario(UsuarioRequestDto dto) {
        if (!bancoAtivo()) {
            return "Banco de dados está indisponível no momento.";
        }

        Optional<Usuario> optUsuario =
                repository.findByEmailAndCpf(dto.getEmail(), dto.getCpf());
        if (optUsuario.isEmpty()) {
            return "Erro ao desativar usuário.";
        }

        Usuario usuario = optUsuario.get();
        usuario.setStatusUsuario(false);
        repository.save(usuario);
        return "Usuário desativado.";
    }

    public boolean bancoAtivo() {
        try {
            entityManager.createNativeQuery("SELECT 1")
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
