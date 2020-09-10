function botao_add() {
    var tipoLancamento = document.getElementById("tipoLancamento");
    var conta = document.getElementById("conta");
    var valor = document.getElementById("valor");
    var pagamento = document.getElementById("formaPagamento");
    var fixa = document.getElementById("fixa");
    var data = document.getElementById("data");
    var responsavel = document.getElementById("responsavel");
    var status = document.getElementById("status");

    if (conta.value == "" || valor.value == "" || data.value == "" || tipoLancamento.value == "" || pagamento.value == "" || fixa.value == "" || responsavel.value == "") {
        alert('Preencha todos os campos');
        return false;
    }

    else{
        alert('Lançamento cadastrado!!!');
    }
}
