package br.com.barbearia.braddock.controller.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
public class ListarAgendamentosRequest {

    private LocalDate data;
}
