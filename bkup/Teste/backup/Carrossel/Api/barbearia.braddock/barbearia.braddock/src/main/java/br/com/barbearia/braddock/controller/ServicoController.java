package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.CriarServicoRequest;
import br.com.barbearia.braddock.controller.response.ServicoResponse;
import br.com.barbearia.braddock.service.AdicionarServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private AdicionarServicoService adicionarServicoService;

    @PostMapping("/criar")
    public ServicoResponse criar(@Valid @RequestBody CriarServicoRequest request){
        return adicionarServicoService.criar(request);
    }

}
