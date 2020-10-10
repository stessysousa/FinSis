<template>
  <div class="hello">
    <div class="login-pai">
      <div class="login-esquerda">
        <h1>Bem Vindo ao FinSis!</h1>
      </div>

      <div class="login-direita">
        <h2 class="loginCriar">Login</h2>
        <form name="form_login" action="" method="POST">
          <div class="form-group">
            <label for="email">Seu e-mail:</label>
            <input
              v-model="email"
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
              v-model="senha"
              name="senha"
              type="password"
              placeholder="abcd1234"
              class="form-control"
              id="senha"
            />
          </div>

          <p v-if="error">Usuario ou senha incorretos!</p>

          <div class="login-botao">
            <input
              type="button"
              name="login"
              value="Login"
              v-on:click="realizarLogin()"
            />
          </div>
        </form>
        <p>Não tem uma conta?<a href="/criarConta"> Criar Conta</a></p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      email: "",
      senha: "",
      error: false,
    };
  },
  methods: {
    realizarLogin: function () {
      if (this.email != "admin@mail.com" || this.senha != "123456")
        this.error = true;
      else {
        this.$router.push({ name: "Index" }).catch(() => {});
      }
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
* {
  padding: 0px;
  margin: 0px;
}

.login-pai {
  display: flex;
  flex-direction: row;
  width: 100vw;
  height: 100vh;
}
/* LOGIN E CADASTRO */
.login-esquerda {
  display: flex;
  flex-direction: column;
  background-color: rgb(121, 121, 218);
  width: 50vw;
  align-items: center;
  justify-content: center;
}

.login-direita {
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

.login-botao {
  text-align: center;
}
</style>
