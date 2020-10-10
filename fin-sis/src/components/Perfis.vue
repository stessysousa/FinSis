<template>
  <div>
    <div class="perfis-cabecalho">
      <h3>FinSis</h3>

      <div class="perfis-direita">
        <h6>Bem Vindo, usuário!</h6>
        <a href="/login">Sair</a>
      </div>
    </div>

    <div class="perfis-menu">
      <ul>
        <li><a href="/index">Página Inicial</a></li>
        <li><a href="/lancamento">Lançamentos</a></li>
        <li><a href="/perfis">Perfis</a></li>
        <li><a href="/configuracoes">Configurações</a></li>
      </ul>
    </div>

    <div class="container">
      <div class="perfis-bordaFormulario">
        <h4>Gerenciar Perfis</h4>
        <div class="row">
          <form action="">
            <div class="row">
              <div class="col-sm">
                <label for="nome">
                  Nome:
                  <input v-model="perfil.nome"
                    name="nome"
                    type="text"
                    id="nome"
                    class="form-control"
                  />
                </label>
              </div>

              <div class="col-sm">
                <label>
                  Tipo de Perfil:
                  <select v-model="perfil.tipo"
                    name="tipoPerfil"
                    class="form-control"
                    id="tipoPerfil"
                  >
                    <option value="" selected></option>
                    <option value="Pessoal">Pessoal</option>
                    <option value="Empresarial">Empresarial</option>
                  </select>
                </label>
              </div>
            </div>
          </form>
        </div>
        <div class="box-actions">
          <input
            type="button"
            class="btn btn-primary"
            value="Adicionar Perfil"
            v-on:click="inserirPerfil()"
          />
          <input type="reset" class="btn btn-danger" value="Limpar" v-on:click="limparPerfil()" />
        </div>
      </div>

      <table class="table" style="width: none">
        <thead class="thead-light">
          <tr>
            <th scope="col">Nome</th>
            <th scope="col">Perfil</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="perfil in perfis" v-bind:key="perfil.id">
            <th scope="col">{{ perfil.nome }}</th>
            <th scope="col">{{ perfil.tipo }}</th>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Perfis",
  data() {
    return {
      perfil: {},
      perfis: [],
      baseURI: "http://localhost:8080/server/api/perfis", //do tom cat
    };
  },
  methods: {
    buscarPerfis: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.perfis = result.data;
      });
    },
    inserirPerfil: function(){
        this.$http.post(this.baseURI, this.perfil).then((result) => {
            this.buscarPerfis();
            this.perfil = {}
      });
    },

    limparPerfil: function(){
        this.perfil = {}
    }
  },
  created() {
    this.buscarPerfis();
  },
};
</script>

<style>
* {
  padding: 0px;
  margin: 0px;
}

.perfis-cabecalho {
  display: flex;
  flex-direction: row;
  background-color: #121e4b;
  width: 100%;
}

/* ------------NOME FINSIS---------*/
.perfis-cabecalho > h3 {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  margin-left: 1.5%;
  font-size: 35px;
  margin-top: 0.5%;
  margin-bottom: 0.5%;
}

/* --------------NOME BEM VINDO USUARIO-----------------*/
.perfis-direita {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  text-align: right;
  margin-left: 75%;
  margin-top: 0.5%;
}

.perfis-direita > a {
  color: #ffffff;
}

.perfis-direita > a:hover {
  color: #ffffff;
}
/* -----------------------MENU-----------------------*/

.perfis-menu > ul {
  margin: 0;
  background-color: rgb(121, 121, 218);
  list-style: none;
}

.perfis-menu > ul > li {
  display: inline;
}

.perfis-menu > ul > li > a {
  padding: 3px 115px;
  display: inline-block;
  text-decoration: none;
  color: #ffffff;
  font-weight: bold;
}

.perfis-menu > ul > li > a:hover {
  color: rgb(121, 121, 218);
}

/* PERFIL */
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  line-height: 20px;
  margin-top: 2%;
}

.box-actions > input {
  width: 200px; /* TAMANHO DOS INPUTS DOS BOTOES */
  border-radius: 5px;
  margin-top: 3%;
}

.perfis-bordaFormulario {
  border: 1px solid;
  border-color: #dcdcdc;
  padding: 20px;
  background-color: #dcdcdc;
  border-radius: 20px;
}

.perfis-bordaFormulario > h4 {
  font-size: 25px;
  margin-bottom: 30px;
  text-align: center;
  font-weight: bolder;
  font-family: "Montserrat", sans-serif;
}
/* ----------------------------------------------*/

table {
  margin-top: 20px;
}
</style>