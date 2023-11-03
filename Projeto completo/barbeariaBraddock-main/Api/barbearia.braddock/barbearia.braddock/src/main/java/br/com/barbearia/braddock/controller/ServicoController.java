package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.CriarServicoRequest;
import br.com.barbearia.braddock.controller.response.ServicoResponse;
import br.com.barbearia.braddock.service.servico.AdicionarServicoService;
import br.com.barbearia.braddock.service.servico.ListarServicosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private AdicionarServicoService adicionarServicoService;

    @Autowired
    private ListarServicosService listarServicosService;

    @PostMapping("/criar")
    public ServicoResponse criar(@Valid @RequestBody CriarServicoRequest request){
        return adicionarServicoService.criar(request);
    }

    @GetMapping
    public List<ServicoResponse> listar(){
        return listarServicosService.listar();
    }

}
