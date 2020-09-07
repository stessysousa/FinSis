function botao_add() {
    var tipoLancamento = document.getElementById("tipoLancamento");
    var conta = document.getElementById("conta");
    var valor = document.getElementById("valor");
    var pagamento = document.getElementById("formaPagamento");
    var fixa = document.getElementById("fixa");
    var data = document.getElementById("data");
    var responsavel = document.getElementById("responsavel");

    
    
    document.querySelector("table").innerHTML += "<tr> <td> " + tipoLancamento.value + " </td> <td>"+ conta.value + "</td> <td>  " + "R$" + valor.value + "</td> <td> " + pagamento.value + " </td> <td> " + fixa.value + " </td> <td>"+ data.value + "</td> <td> " + responsavel.value + "</td>  </tr>"; //innerHTML cria html onde selecionou, usando tag que selecionei (table)

}
