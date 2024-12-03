package br.com.jera.tads.apimanutencaoequipamento.modules.cliente.controllers;


import br.com.jera.tads.apimanutencaoequipamento.modules.cliente.ClienteEntity;
import br.com.jera.tads.apimanutencaoequipamento.modules.cliente.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/")
    public ClienteEntity create(@Valid @RequestBody ClienteEntity clientEntity) {
        return this.clienteRepository.save(clientEntity);
    }
}
