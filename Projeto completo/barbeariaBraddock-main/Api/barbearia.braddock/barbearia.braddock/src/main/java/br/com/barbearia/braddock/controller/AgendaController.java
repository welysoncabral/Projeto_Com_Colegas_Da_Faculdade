package br.com.barbearia.braddock.controller;

import br.com.barbearia.braddock.controller.request.AgendarRequest;
import br.com.barbearia.braddock.controller.response.AgendaResponse;
import br.com.barbearia.braddock.service.agenda.ListarAgendamentosService;
import br.com.barbearia.braddock.service.agenda.AgendarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
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

    @GetMapping("/{nomeFuncionario}/{dia}/{mes}/{ano}")
    public List<AgendaResponse> porFuncionarioEDia(@PathVariable String nomeFuncionario, @PathVariable int dia,@PathVariable int mes, @PathVariable int ano){
        return listarAgendamentosService.listarPorFuncionarioEDia(nomeFuncionario, dia, mes, ano);
    }

    @GetMapping("/{nomeFuncionario}")
    public List<AgendaResponse> porFuncionario(@PathVariable String nomeFuncionario){
        return listarAgendamentosService.listarPorFuncionario(nomeFuncionario);
    }
}
