package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.service.ListarAgendamentosService;
import br.com.barbearia.braddock.service.agenda.AgendarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    @Autowired
    private AgendarService agendarService;

    @Autowired
    private ListarAgendamentosService listarAgendamentosService;

    @PostMapping("/agendar")
    public void agendar(@Valid @RequestBody AgendarRequest request){
        agendarService.agendar(request);
    }

    @GetMapping("/{id}/{dia}/{mes}/{ano}")
    public List<AgendaResponse> porFuncionarioEDia(@PathVariable Long id, @PathVariable int dia,@PathVariable int mes, @PathVariable int ano){
        return listarAgendamentosService.listarPorFuncionarioEDia(id, dia, mes, ano);
    }

    @GetMapping("/{id}")
    public List<AgendaResponse> porFuncionario(@PathVariable Long id){
        return listarAgendamentosService.listarPorFuncionario(id);
    }
}
