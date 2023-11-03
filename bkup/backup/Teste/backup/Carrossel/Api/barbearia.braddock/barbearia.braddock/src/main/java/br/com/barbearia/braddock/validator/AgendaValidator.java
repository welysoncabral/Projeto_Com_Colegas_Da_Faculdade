package br.com.barbearia.braddock.validator;

import br.com.barbearia.braddock.domain.Agenda;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Component
public class AgendaValidator {

    public void horarioDeTrabalho(LocalDateTime horarioInicio) {

        int horarioAbertura = 8;
        int horarioFechamento = 20;
        int horarioPararAtendimento = (horarioFechamento - 1);


        if(horarioInicio.getHour() < horarioAbertura){
            throw new ResponseStatusException(BAD_REQUEST, "Horário escolhido está antes do horário de abertura, tente depois das " + horarioAbertura + " horas");
        }

        if(horarioInicio.getHour() > horarioPararAtendimento){
            throw new ResponseStatusException(BAD_REQUEST, "Nos fechamos as " + horarioFechamento + " horas, porém paramos de atender as " + horarioPararAtendimento + " horas para evitar atrasos");
        }
    }

    public void validaHorarioConflitante(LocalDateTime horarioInicio, LocalDateTime horarioFinal, Agenda agenda) {
        if(horarioInicio.isBefore(agenda.getHorarioFim()) && horarioFinal.isAfter(agenda.getHorarioInicio())){
            throw new ResponseStatusException(BAD_REQUEST, "Este horário já está ocupado |" + agenda.getHorarioInicio().getHour() + ":" + agenda.getHorarioInicio().getMinute() + " até " + agenda.getHorarioFim().getHour() + ":" + agenda.getHorarioFim().getMinute());
        }
    }
}
