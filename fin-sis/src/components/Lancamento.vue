<template>
  <div>
    <div class="lancamento-cabecalho">
      <h3>FinSis</h3>

      <div class="lancamento-direita">
        <h6>Bem Vindo, usuário!</h6>
        <a href="/login">Sair</a>
      </div>
    </div>

    <div class="lancamento-menu">
      <ul>
        <li><a href="/index">Página Inicial</a></li>
        <li><a href="/lancamento">Lançamentos</a></li>
        <li><a href="/perfis">Perfis</a></li>
        <li><a href="/configuracoes">Configurações</a></li>
      </ul>
    </div>

    <div class="container">
      <form name="formLancamento" action="" method="submit">
        <div class="bordaFormulario">
          <h4>Novo Lançamento</h4>

          <div class="row">
            <div class="col-sm">
              <label>
                Tipo de Lançamento:
                <select
                  v-model="lancamento.tipo"
                  name="tipoLancamento"
                  class="form-control"
                  id="tipoLancamento"
                >
                  <option value=""></option>
                  <option value="Receita">Receita</option>
                  <option value="Despesa">Despesa</option>
                </select>
              </label>
            </div>

            <div class="col-sm">
              <label for="conta"
                >Nome do Lançamento:
                <input
                  v-model="lancamento.nome"
                  name="conta"
                  type="text"
                  placeholder="Energia, água"
                  class="form-control"
                  id="conta"
              /></label>
            </div>

            <div class="col-sm">
              <label for="valor"
                >Valor:
                <input
                  v-model="lancamento.valor"
                  name="valor"
                  type="number"
                  placeholder="R$ 230.00"
                  class="form-control"
                  id="valor"
              /></label>
            </div>
          </div>

          <div class="row">
            <div class="col-sm">
              <label
                >Forma de Pagamento:
                <select
                  v-model="lancamento.pagamento"
                  name="pagamento"
                  class="form-control"
                  id="pagamento"
                >
                  <option value=""></option>
                  <option value="Cartão">Cartão</option>
                  <option value="À vista">À vista</option>
                  <option value="Boleto">Boleto</option>
                  <option value="Transferência">Transferência</option>
                </select>
              </label>
            </div>

            <div class="col-sm">
              <label
                >Lançamento Fixo:
                <select
                  name="fixa"
                  class="form-control"
                  id="fixa"
                  v-model="lancamento.fixo"
                >
                  <option value=""></option>
                  <option value="Sim">Sim</option>
                  <option value="Não">Não</option>
                </select>
              </label>
            </div>

            <div class="col-sm">
              <label for="data"
                >Data:
                <input
                  v-model="lancamento.data"
                  name="data"
                  type="String"
                  placeholder="23/16/2019"
                  class="form-control"
                  id="data"
              /></label>
            </div>
          </div>

          <div class="row">
            <div class="col-sm">
              <label for="responsavel"
                >Responsável:
                <input
                  v-model="lancamento.perfil"
                  name="perfil"
                  type="text"
                  placeholder="Ex: Maria"
                  class="form-control"
                  id="perfil"
              /></label>
            </div>

            <div class="col-sm">
              <label for="descricao"
                >Descrição:
                <input
                  v-model="lancamento.descricao"
                  name="descricao"
                  type="text"
                  placeholder="Obrigatório"
                  class="form-control"
                  id="descricao"
              /></label>
            </div>

            <div class="col-sm">
              <label
                >Status:
                <select
                  name="status"
                  class="form-control"
                  id="status"
                  v-model="lancamento.status"
                >
                  <option value=""></option>
                  <option value="paga">Paga</option>
                  <option value="atrasada">Atrasada</option>
                  <option value="aberta">Aberta</option>
                </select>
              </label>
            </div>
          </div>
          <div class="box-actions">
            <input
              type="button"
              class="btn btn-primary"
              value="Salvar Lançamento"
              v-on:click="inserirLancamento()"
            />
            <input type="reset" class="btn btn-danger" value="Limpar" />
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Lancamento",
  data() {
    return {
      baseURI: "http://localhost:8080/server/api/lancamentos",
      lancamento: {},
    };
  },

  methods: {
    inserirLancamento: function () {
        this.$http.post(this.baseURI, this.lancamento).then((result) => {
          this.lancamento = {};
        });
    },

    limparLancamento: function () {
      this.lancamento = {};
    },
  },
};
</script>

<style>
* {
  padding: 0px;
  margin: 0px;
}

.lancamento-cabecalho {
  display: flex;
  flex-direction: row;
  background-color: #121e4b;
  width: 100%;
}

/* ------------NOME FINSIS---------*/
.lancamento-cabecalho > h3 {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  margin-left: 1.5%;
  font-size: 35px;
  margin-top: 0.5%;
  margin-bottom: 0.5%;
}

/* --------------NOME BEM VINDO USUARIO-----------------*/
.lancamento-direita {
  color: #ffffff;
  font-family: "Montserrat", sans-serif;
  text-align: right;
  margin-left: 75%;
  margin-top: 0.5%;
}

.lancamento-direita > a {
  color: #ffffff;
}

.lancamento-direita > a:hover {
  color: #ffffff;
}
/* -----------------------MENU-----------------------*/

.lancamento-menu > ul {
  margin: 0;
  background-color: rgb(121, 121, 218);
  list-style: none;
}

.lancamento-menu > ul > li {
  display: inline;
}

.lancamento-menu > ul > li > a {
  padding: 3px 115px;
  display: inline-block;
  text-decoration: none;
  color: #ffffff;
  font-weight: bold;
}

.lancamento-menu > ul > li > a:hover {
  color: rgb(121, 121, 218);
}

/* LANÇAMENTO */
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  line-height: 20px;
  margin-top: 2%;
}

.container select {
  width: 250px; /* Tamanho do select, maior que o tamanho da div "div-select" */
}

.container input {
  /* TAMANHO DAS CAIXAS INPUT */
  width: 250px;
  padding: 5px;
}

.col-sm > input {
  /* CAIXAS INPUT */
  border-radius: 5px;
}

.col-sm > label {
  font-family: "Montserrat", sans-serif;
  margin: 10px; /* ESPAÇAMENTO DA LABEL DO FORM LANÇAMENTO */
}

.box-actions {
  /*  DISTÂNCIAS DOS BOTÕES DO FORM LANCAMENTO PARA OS INPUS */
  margin-top: 15px;
  text-align: center;
}
.box-actions > input {
  width: 300px; /* TAMANHO DOS INPUTS DOS BOTOES */
  border-radius: 5px;
}

.bordaFormulario {
  border: 1px solid;
  border-color: #dcdcdc;
  padding: 10px;
  background-color: #dcdcdc;
  border-radius: 10px;
}

.bordaFormulario > h4 {
  font-size: 25px;
  margin-bottom: 25px;
  text-align: center;
  font-weight: bolder;
  font-family: "Montserrat", sans-serif;
}
/* ----------------------------------------------*/

table {
  margin-top: 5%;
  margin-left: 15%;
}
</style>