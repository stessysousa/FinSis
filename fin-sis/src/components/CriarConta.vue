<template>
  <div class="pai">
    <div class="esquerda">
      <h1>Bem Vindo ao SisFis!</h1>
    </div>

    <div class="direita">
      <h2 class="loginCriar">Criar Conta</h2>
      <form name="formCadastro" action="" method="POST">
        <div class="form-group">
          <label for="nome">Seu nome:</label>
          <input
            name="nome"
            type="text"
            placeholder="Nome Sobrenome"
            class="form-control"
            id="nome"
          />
        </div>
        <div class="form-group">
          <label for="email">Seu e-mail:</label>
          <input
            name="email"
            type="text"
            placeholder="exemplo@gmail.com"
            class="form-control"
            id="email"
          />
        </div>
        <div class="form-group">
          <label for="senha">Sua senha:</label>
          <input
            name="nome"
            type="password"
            placeholder="abcd1234"
            class="form-control"
            id="senha"
          />
        </div>
        <div class="botao">
          <input
            type="button"
            name="cadastro"
            value="Cadastrar"
            onclick="return validarCadastro()"
          />
        </div>
      </form>
      <p>Já tem uma conta?<a href="/login"> Faça Login</a></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CriarConta"
};
</script>

<style>
*{
    padding: 0px;
    margin: 0px;
}

.pai{
    display: flex;
    flex-direction: row;
    width: 100vw;
    height: 100vh;
}
/* LOGIN E CADASTRO */
.esquerda{
    display: flex;
    flex-direction: column;
    background-color: rgb(121, 121, 218);
    width:50vw;
    align-items: center;
    justify-content: center;    
}

.direita{
    display: flex;
    flex-direction: column;
    background-color: #FFFFFF;
    width: 50vw;
    padding: 10%;
    justify-content: center;
}

h1{
    text-align: center;
    color: #FFFFFF;
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size:70px;
}

.loginCriar{
    text-align: center;
    color: rgb(121, 121, 218);  
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size:40px;
}

p{
    text-align: center;
    margin-top: 40px;
}

.botao > input{
    width: 100%;
    height: 35px;
    margin-top: 3%;
    color: #d9d9d9;
    background-color: rgb(121, 121, 218);
    border-radius: 5px;
}

.botao{
    text-align: center;   
}

</style>