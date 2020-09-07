function validar(){
    var email = document.getElementById("email");
    var senha = document.getElementById("senha");

    var filterEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;

    if(!filterEmail.test(email.value)){
        alert('Por favor, digite um email válido');
        email.focus();
        return false;
    }
    if (senha.value == "" || senha.value.length < 8) {
        alert('Preencha o campo senha com minimo 8 caracteres');
        senha.focus();
        return false;
    }
    window.location.assign("index.html");
}