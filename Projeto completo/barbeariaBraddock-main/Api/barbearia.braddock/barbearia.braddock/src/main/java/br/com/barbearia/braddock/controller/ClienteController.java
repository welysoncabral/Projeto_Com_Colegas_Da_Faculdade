package br.com.barbearia.braddock.controller;


import br.com.barbearia.braddock.controller.request.CriarClienteRequest;
import br.com.barbearia.braddock.controller.request.EntrarEmContatoRequest;
import br.com.barbearia.braddock.controller.request.LogarClienteRequest;
import br.com.barbearia.braddock.service.cliente.EntrarEmContatoService;
import br.com.barbearia.braddock.service.cliente.LogarClienteService;
import br.com.barbearia.braddock.service.cliente.CriarClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private CriarClienteService criarClienteService;

    @Autowired
    private LogarClienteService logarClienteService;


    @Autowired
    private EntrarEmContatoService entrarEmContatoService;

    @PostMapping("/criar")
    public void criar(@Valid @RequestBody CriarClienteRequest request){
        criarClienteService.criar(request);
    }

    @GetMapping("/logar")
    public boolean logar(@Valid @RequestBody LogarClienteRequest request){
        return logarClienteService.logar(request);
    }

    @PostMapping("/contato")
    public void entrarEmContato(@Valid @RequestBody EntrarEmContatoRequest request){
        entrarEmContatoService.enviar(request);
    }

}
