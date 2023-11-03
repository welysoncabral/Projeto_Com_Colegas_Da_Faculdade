package br.com.barbearia.braddock.controller;


import br.com.barbearia.braddock.controller.request.AdicionarTelefoneRequest;
import br.com.barbearia.braddock.service.telefone.CadastrarTelefoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/telefone")
public class TelefoneController {


    @Autowired
    private CadastrarTelefoneService cadastrarTelefoneService;

    @PostMapping("/adicionar")
    public void adicionarTelefone(@Valid @RequestBody AdicionarTelefoneRequest request){
        cadastrarTelefoneService.adicionar(request);
    }
}
