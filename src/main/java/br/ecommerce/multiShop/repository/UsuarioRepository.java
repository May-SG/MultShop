package br.ecommerce.multiShop.repository;

import br.ecommerce.multiShop.model.Usuario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @EntityGraph(attributePaths = {"contato", "endereco"})
    Optional<Usuario> findAllByNome(String nome);

    @EntityGraph(attributePaths = {"contato", "endereco"})
    Optional<Usuario> findAllByCpf(String cpf);

    @EntityGraph(attributePaths = {"contato", "endereco"})
    Optional<Usuario> findAllByEmail(String email);

    @EntityGraph(attributePaths = {"contato", "endereco"})
    Optional<Usuario> findByEmailAndCpf(String email, String cpf);

}
