function novoPerfil(){
var nome= document.getElementById("nome");
var perfil= document.getElementById("tipoPerfil");

document.querySelector("table").innerHTML += "<tr> <td> " + nome.value + " </td>  <td>"+ perfil.value + "</td>  </tr>";
alert("Adicionado com sucesso");
}
