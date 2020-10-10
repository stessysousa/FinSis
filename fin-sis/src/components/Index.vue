<template>
  <div>
    <div class="index-cabecalho">
      <h3>FinSis</h3>

      <div class="index-direita">
        <h6>Bem Vindo, usuário!</h6>
        <a href="/login">Sair</a>
      </div>
    </div>

    <div class="index-menu">
      <ul>
        <li><a href="/index">Página Inicial</a></li>
        <li><a href="/lancamento">Lançamentos</a></li>
        <li><a href="/perfis">Perfis</a></li>
        <li><a href="/configuracoes">Configurações</a></li>
      </ul>
    </div>

    <!-- <div class="dash">
      <div class="row">
        <div class="col-xs-6" style="color: green">
          <p>Receitas: R$ 370,00</p>
        </div>
        <div class="col-xs-6" style="color: red">
          <p>Despesas: R$ 180,00</p>
        </div>
        <div class="col-xs-6" style="color: rgb(231, 194, 27)">
          <p>Saldo Disponível: R$ 190,00</p>
        </div>
      </div>
    </div> -->

    <div class="table">
      <!-- <div class="buscar">
                <label for="busca" placeholder="Buscar Lançamentos"></label>
                <input type="search" id="buscar">
                <button type="submit">Buscar</button> 
            </div> -->

      <table>
        <thead class="thead-light">
          <tr>
            <th>Tipo</th>
            <th>Nome do Lançamento</th>
            <th>Data</th>
            <th>Perfil</th>
            <th>Funções</th>
          </tr>
        </thead>

        <tbody>
          <tr v-for="lancamento in lancamentos" v-bind:key="lancamento.id">
            <td scope="col">{{lancamento.tipo}}</td>
            <td scope="col">{{lancamento.nome}}</td>
            <td scope="col">{{lancamento.data}}</td>
            <td scope="col">{{lancamento.perfil}}</td>
            <td scope="col">
              <a href="/visualizarLancamento">Visualizar</a>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      lancamentos: [],
      baseURI: "http://localhost:8080/server/api/lancamentos", //do tom cat
    };
  },
  methods: {
    buscarLancamentos: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.lancamentos = result.data;
        console.log(result.data);
      });
    },
  },
  created() {
    this.buscarLancamentos();
  },
};
</script>

<style>
* {
  padding: 0px;
  margin: 0px;
}

.index-cabecalho {
  display: flex;
  flex-direction: row;
  background-color: #121e4b;
  width: 100%;
}

.index-cabecalho > h3 {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  margin-left: 1.5%;
  font-size: 35px;
  margin-top: 0.5%;
  margin-bottom: 0.5%;
}

/* --------------NOME BEM VINDO USUARIO-----------------*/
.index-direita {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  text-align: right;
  margin-left: 75%;
  margin-top: 0.5%;
}

.index-direita > a {
  color: #ffffff;
}

.index-direita > a:hover {
  color: #ffffff;
}

/* -----------------------MENU-----------------------*/
.index-menu > ul {
  margin: 0px;
  padding: 0px;
  background-color: rgb(121, 121, 218);
  list-style: none;
}

.index-menu > ul > li {
  display: inline;
}

.index-menu > ul > li > a {
  padding: 3px 115px;
  display: inline-block;
  text-decoration: none;
  color: #ffffff;
  font-weight: bold;
}

.index-menu > ul > li > a:hover {
  color: rgb(121, 121, 218);
}

.dash {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 10px;
}

.col-xs-6 {
  font-size: 25px;
  font-weight: bold;
  font-family: "Montserrat", sans-serif;
  margin-left: 30px;
  margin-right: 30px;
}

table {
  width: 70%;
  margin: 0 auto;
  margin-top: 5%;
}

.buscar {
  display: flex;
  flex-direction: row;
  text-align: center;
}
.buscar > input {
  width: 20%;
}
</style>