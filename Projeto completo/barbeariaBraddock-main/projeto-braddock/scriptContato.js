const formularioContato = document.querySelector(".formContato");
const InomeContato = document.querySelector(".nomeContato");
const IemailContato = document.querySelector(".emailContato");
const InumeroContato = document.querySelector(".numeroContato");
const IcontatoContato = document.querySelector(".contatoContato");

function enviarContato() {
  fetch("http://localhost:8080/cliente/contato", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"
    },
    method: "POST",
    body: JSON.stringify({
      nome: InomeContato.value,
      email: IemailContato.value,
      numero: InumeroContato.value,
      mensagem: IcontatoContato.value
    })
  })
    .then(function (res) {
      console.log(res);
    })
    .catch(function (res) {
      console.log(res);
    });
}

formularioContato.addEventListener("submit", function (event) {
  event.preventDefault();

  enviarContato();
});
