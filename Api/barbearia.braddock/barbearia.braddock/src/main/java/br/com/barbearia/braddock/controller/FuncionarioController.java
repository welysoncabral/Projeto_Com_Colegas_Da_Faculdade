package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.CriarFuncionarioRequest;
import br.com.barbearia.braddock.controller.response.FuncionarioResponse;
import br.com.barbearia.braddock.service.funcionario.CriarFuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private CriarFuncionarioService criarFuncionarioService;

    @PostMapping("/criar")
    public FuncionarioResponse criarFuncionario(@Valid @RequestBody CriarFuncionarioRequest request){
        return criarFuncionarioService.criar(request);
    }

}
