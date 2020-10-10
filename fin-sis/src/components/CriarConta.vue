<template>
  <div class="pai">
    <div class="esquerda">
      <h1>Bem Vindo ao FinSis!</h1>
    </div>

    <div class="direita">
      <h2 class="loginCriar">Criar Conta</h2>
      <form name="formCadastro" action="" method="POST">
        <div class="form-group">
          <label for="nome">Seu nome:</label>
          <input
            v-model="usuario.nome"
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
            v-model="usuario.email"
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
            v-model="usuario.senha"
            name="nome"
            type="password"
            placeholder="abcd1234"
            class="form-control"
            id="senha"
          />
        </div>
        <p v-if="error">Preencha com valores válidos!</p>
        <div class="botao">
          <input
            type="button"
            name="cadastro"
            value="Cadastrar"
            v-on:click="criarConta()"
          />
        </div>
      </form>
      <p>Já tem uma conta?<a href="/login"> Faça Login</a></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "CriarConta",
  data() {
    return {
      baseURI: "http://localhost:8080/server/api/usuario",
      usuario: {},
      error: false,
      nome: "",
      email: "",
      senha: "",
    };
  },

  //this.nome == "" || this.email == "" || this.senha == ""

  methods: {
    criarConta: function () {
      if (nome.usuario == "" || email.usuario == "" || senha.usuario == "")
        this.error = true;
      else {
        this.$http.post(this.baseURI, this.usuario).then((result) => {
          this.usuario = {};
          this.$router.push({ name: "Index" }).catch(() => {});
        });
      }
    },
  },
};
</script>

<style>
* {
  padding: 0px;
  margin: 0px;
}

.pai {
  display: flex;
  flex-direction: row;
  width: 100vw;
  height: 100vh;
}
/* LOGIN E CADASTRO */
.esquerda {
  display: flex;
  flex-direction: column;
  background-color: rgb(121, 121, 218);
  width: 50vw;
  align-items: center;
  justify-content: center;
}

.direita {
  display: flex;
  flex-direction: column;
  background-color: #ffffff;
  width: 50vw;
  padding: 10%;
  justify-content: center;
}

h1 {
  text-align: center;
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  font-size: 70px;
}

.loginCriar {
  text-align: center;
  color: rgb(121, 121, 218);
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  font-size: 40px;
}

p {
  text-align: center;
  margin-top: 40px;
}

.botao > input {
  width: 100%;
  height: 35px;
  margin-top: 3%;
  color: #d9d9d9;
  background-color: rgb(121, 121, 218);
  border-radius: 5px;
}

.botao {
  text-align: center;
}
</style>