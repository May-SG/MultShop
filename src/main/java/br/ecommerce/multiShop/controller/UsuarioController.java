package br.ecommerce.multiShop.controller;

import br.ecommerce.multiShop.dto.UsuarioDto;
import br.ecommerce.multiShop.model.Usuario;
import br.ecommerce.multiShop.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String get() {
        return "Loja Virtual - API está rodando!";
    }

    @GetMapping("/nome")
    public ResponseEntity<UsuarioDto> findAllByNome (@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new UsuarioDto(service.findAllByNome(nome)));
    }

    @GetMapping("/email")
    public ResponseEntity<UsuarioDto> findAllByEmail (@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new UsuarioDto(service.findAllByEmail(email)));
    }

    @GetMapping("/cpf")
    public ResponseEntity<UsuarioDto> findAllByCpf (@RequestParam String cpf) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(new UsuarioDto(service.findAllByCpf(cpf)));
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> newUser (@RequestBody UsuarioDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(dto));
    }

    @PutMapping("/UpdateName")
    public ResponseEntity<Usuario> UpdateName (@RequestParam UsuarioDto dto) {
        return null; //ResponseEntity.status(HttpStatus.ACCEPTED)
                //.body(service.updateNome(dto));
    }

    @PutMapping("/UpdateEmail")
    public ResponseEntity<String> UpdateEmail (UsuarioDto usuario) {
        return new ResponseEntity<>("E-mail alterado", HttpStatus.OK);
    }

    @PutMapping("/UpdatePassword")
    public ResponseEntity<String> UpdatePassword (UsuarioDto usuario) {
        return new ResponseEntity<>("Senha alterada", HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser (UsuarioDto usuario) {
        return new ResponseEntity<>("Usuário deletado", HttpStatus.OK);
    }

}