package br.ecommerce.multiShop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @GetMapping("/")
    public String get() {
        return "Loja Virtual - API está rodando!";
    }

    @GetMapping("/findByPhone")
    public ResponseEntity<String> findByPhone () {
        return new ResponseEntity<>("Usuário encontrado", HttpStatus.FOUND);
    }

    @GetMapping("/findByLandlinePhone")
    public ResponseEntity<String> findByLandlinePhone () {
        return new ResponseEntity<>("Usuário encontrado", HttpStatus.FOUND);
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
