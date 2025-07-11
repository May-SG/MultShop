package br.ecommerce.multiShop.repository;

import br.ecommerce.multiShop.dto.UsuarioResponseDto;
import br.ecommerce.multiShop.model.Contato;
import br.ecommerce.multiShop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query(value = "SELECT u.* FROM usuario u join contato c on u.id = c.usuario_id " +
            "join endereco e on u.id = e.usuario_id where celular = :celular", nativeQuery = true)
    Optional<Usuario> findAllByCelular(@Param("celular") String celular);

    @Query(value = "SELECT u.* FROM usuario u JOIN contato c ON u.id = c.usuario_id" +
            "JOIN endereco e ON u.id = e.usuario_id WHERE telefone = :telefone", nativeQuery = true)
    Optional<Usuario> findAllByTelefone(@Param("telefone") String telefone);

}
