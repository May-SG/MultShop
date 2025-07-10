package br.ecommerce.multiShop.repository;

import br.ecommerce.multiShop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findAllByNome(String nome);

    Optional<Usuario> findAllByCpf(String cpf);

    Optional<Usuario> findAllByEmail(String email);

}
