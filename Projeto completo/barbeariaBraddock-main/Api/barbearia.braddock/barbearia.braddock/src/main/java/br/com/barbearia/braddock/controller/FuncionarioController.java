package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.CriarFuncionarioRequest;
import br.com.barbearia.braddock.controller.response.FuncionarioResponse;
import br.com.barbearia.braddock.service.funcionario.ListarFuncionariosService;
import br.com.barbearia.braddock.service.funcionario.CriarFuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private CriarFuncionarioService criarFuncionarioService;

    @Autowired
    private ListarFuncionariosService listarFuncionariosService;

    @PostMapping("/criar")
    public FuncionarioResponse criarFuncionario(@Valid @RequestBody CriarFuncionarioRequest request){
        return criarFuncionarioService.criar(request);
    }

    @GetMapping
    public List<FuncionarioResponse> listarFuncionarios(){
        return listarFuncionariosService.listar();
    }

}
