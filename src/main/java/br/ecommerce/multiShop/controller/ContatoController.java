package br.ecommerce.multiShop.controller;

import br.ecommerce.multiShop.dto.UsuarioResponseDto;
import br.ecommerce.multiShop.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    private final ContatoService service;
    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping("/celular")
    public ResponseEntity<UsuarioResponseDto> findByPhone (@RequestParam String celular) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.findByPhone(celular));
    }

    @GetMapping("/telefone")
    public ResponseEntity<UsuarioResponseDto> findByLandlinePhone (@RequestParam String telefone) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service.findByLandLinePhone(telefone));
    }

    @PutMapping("/UpdatePhone")
    public ResponseEntity<String> UpdatePhone () {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/UpdateLandlinePhone")
    public ResponseEntity<String> UpdateLandlinePhone () {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PutMapping("/UpdateDDD")
    public ResponseEntity<String> UpdateDDD () {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
