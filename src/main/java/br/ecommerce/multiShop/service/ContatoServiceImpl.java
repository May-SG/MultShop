package br.ecommerce.multiShop.service;

import br.ecommerce.multiShop.dto.UsuarioResponseDto;
import br.ecommerce.multiShop.exception.ResourceNotFoundException;
import br.ecommerce.multiShop.mapper.ResponseMapper;
import br.ecommerce.multiShop.model.Usuario;
import br.ecommerce.multiShop.repository.ContatoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl implements ContatoService {

    private final ContatoRepository repository;
    private final ResponseMapper mapper;
    public ContatoServiceImpl(ContatoRepository repository, ResponseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioResponseDto findByPhone(String celular) {
        Usuario usuario = repository.findAllByCelular(celular)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não consta na base de dados."));
        return mapper.toResponseDto(usuario);
    }

    @Override
    public UsuarioResponseDto findByLandLinePhone(String telefone) {
        Usuario usuario = repository.findAllByTelefone(telefone)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Usuário não consta na base de dados."));
        return mapper.toResponseDto(usuario);
    }

}
