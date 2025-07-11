package br.ecommerce.multiShop.controller;

import br.ecommerce.multiShop.dto.*;
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

    @GetMapping("/nome")
    public ResponseEntity<UsuarioResponseDto> findAllByNome (@RequestParam String nome) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.findAllByNome(nome));
    }

    @GetMapping("/email")
    public ResponseEntity<UsuarioResponseDto> findAllByEmail (@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.findAllByEmail(email));
    }

    @GetMapping("/cpf")
    public ResponseEntity<UsuarioResponseDto> findAllByCpf (@RequestParam String cpf) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.findAllByCpf(cpf));
    }

    @PostMapping("/save")
    public ResponseEntity<UsuarioResponseDto> newUser (@RequestBody UsuarioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(dto));
    }

    @PutMapping("/alterarNome")
    public ResponseEntity<String> UpdateName (@RequestBody AtualizarNomeDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarNome(dto));
    }

    @PutMapping("/alterarEmail")
    public ResponseEntity<String> atualizarEmail (@RequestBody AtualizarEmailDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarEmail(dto));
    }

    @PutMapping("/alterarSenha")
    public ResponseEntity<String> UpdatePassword (@RequestBody AtualizarSenhaDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.atualizarSenha(dto));
    }

    @DeleteMapping("/desativar")
    public ResponseEntity<String> deleteUser (@RequestBody UsuarioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.desativarUsusario(dto));
    }

}