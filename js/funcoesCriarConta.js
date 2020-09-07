function validarCadastro() {
    var nome = document.getElementById("nome");
    var email = document.getElementById("email");
    var senha = document.getElementById("senha");
    var filterEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i; 
    var filterNome = /^([a-zA-Zà-úÀ-Ú0-9]|-|_|\s)+$/;


    if(!filterNome.test(nome.value)){
        alert("Prencha com um nome válido");
        nome.placeholder = "Insira um nome válido";
        nome.focus();
        return false;
    }

    if(!filterEmail.test(email.value)){
        alert('Por favor, digite o email corretamente');
        email.focus();
        return false
        }

    if (senha.value == "" || senha.value.length < 8) {
        alert('Preencha o campo senha com minimo 8 caracteres');
        senha.focus();
        return false;
    }
        alert("Cadastro criado com sucesso");
        window.location.assign("index.html");

}