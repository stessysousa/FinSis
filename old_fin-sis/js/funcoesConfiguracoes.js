function validarDados(){
    var inputs = document.getElementsByClassName('form-control');
    var len = inputs.length;
   var valid = true;
    for (var i = 0; i < len; i++) {
      if (!inputs[i].value) {
        valid = false;
      }
    }
    if (!valid) {
      alert('Preencha todos os campos');
      return false;
    } else {
      location.href='configurações.html';
      alert('Os dados foram atualizados');
      return true
    }
    
   
  }