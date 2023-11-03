const formularioAgenda = document.querySelector(".formAgenda");
const InomeAgenda = document.querySelector(".nomeAgenda");
const IemailAgenda = document.querySelector(".emailAgenda");
const InumeroAgenda = document.querySelector(".numeroAgenda");
const IdataAgenda = document.querySelector(".dataAgenda");
const IhorarioAgenda = document.querySelector(".horarioAgenda");
const IservicoAgenda = document.querySelector(".servicoAgenda");
const IfuncionarioAgenda = document.querySelector(".funcionarioAgenda");

function limparTela() {
  InomeAgenda.value = "";
  IemailAgenda.value = "";
  InumeroAgenda.value = "";
  IdataAgenda.value = "";
  IhorarioAgenda.value = "";
  IservicoAgenda.value = "";
  IfuncionarioAgenda.value = "";
}

function enviarAgenda() {
  const horarioInicio = IdataAgenda.value + "T" + IhorarioAgenda.value + ":00";
  console.log(horarioInicio);
  fetch("http://localhost:8080/agenda/agendar", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"
    },
    method: "POST",
    body: JSON.stringify({
      nomeCliente: InomeAgenda.value,
      telefone: InumeroAgenda.value,
      nomeFuncionario: IfuncionarioAgenda.value,
      servico: IservicoAgenda.value,
      horarioInicio: horarioInicio
    })
  })
    .then(function (res) {
      console.log(res);
      limparTela();
    })
    .catch(function (res) {
      console.log(res);
    });
}

formularioAgenda.addEventListener("submit", function (event) {
  event.preventDefault();

  enviarAgenda();
});