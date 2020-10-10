<template>
  <div>

    <div class="visualizar-cabecalho">
        <h3>SisFis</h3>

        <div class="visualizar-direita">
            <h6>Bem Vindo, usuário!</h6>
            <a href="/login">Sair</a>
        </div>
    </div>

    <div class="visualizar-menu">
        <ul>
            <li><a href="/index">Página Inicial</a></li>
            <li><a href="/lancamento">Lançamentos</a></li>
            <li><a href="/perfis">Perfis</a></li>
            <li><a href="/configuracoes">Configurações</a></li>
        </ul>
    </div>

    <div class="container">
        <form name="formLancamento" action="" method="submit">

            <div class="visualizar-bordaFormulario">

                <h4>Atualizar Lançamento</h4>

                <div class="row">
                    <div class="col-sm">
                        <label> Tipo de Lançamento:
                            <select name="tipoLancamento" class="form-control" id="tipoLancamento">
                                <option value=""></option>
                                <option value="Receita" selected>Receita</option>
                                <option value="Despesa">Despesa</option>
                            </select>
                        </label>
                    </div>

                    <div class="col-sm">
                        <label for="conta">Nome do Lançamento:
                            <input name="conta" type="text" placeholder="Energia, água" class="form-control"
                                id="conta" value="Conta de água"/></label>
                    </div>

                    <div class="col-sm">
                        <label for="valor">Valor:
                            <input name="valor" type="number" placeholder="R$ 230.00" class="form-control"
                                id="valor" value="20.00" /></label>
                    </div>

                </div>

                <div class="row">
                    <div class="col-sm">
                        <label>Forma de Pagamento:
                            <select name="pagamento" class="form-control" id="pagamento">
                                <option value=""></option>
                                <option value="Cartão" selected>Cartão</option>
                                <option value="À vista">À vista</option>
                                <option value="Boleto">Boleto</option>
                                <option value="Transferência">Transferência</option>
                            </select>
                        </label>
                    </div>

                    <div class="col-sm">
                        <label>Lançamento Fixo:
                            <select name="fixa" class="form-control" id="fixa">
                                <option value=""></option>
                                <option value="Sim" selected>Sim</option>
                                <option value="Não">Não</option>
                            </select>
                        </label>
                    </div>

                    <div class="col-sm">
                        <label for="data">Data:
                            <input name="data" type="date" value="02/02/20" placeholder="23/16/2019" class="form-control"
                                id="data" /></label>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm">
                        <label for="responsavel">Responsável:
                            <input name="responsavel" value="Maria" type="text" placeholder="Ex: Maria" class="form-control"
                                id="responsavel" /></label>
                    </div>

                    <div class="col-sm">
                        <label for="descricao">Descrição:
                            <input name="descricao" type="text" placeholder="Opcional" class="form-control"
                                id="descricao" /></label>
                    </div>

                    <div class="col-sm">
                        <label>Status:
                            <select name="status" class="form-control" id="status">
                                <option value=""></option>
                                <option value="Paga" selected>Paga</option>
                                <option value="atrasada">Atrasada</option>
                                <option value="aberta">Aberta</option>
                            </select>
                        </label>
                    </div>
                    <div class="box-actions" style="margin-left: 25px;">
                        <input type="button" class="btn btn-primary" value="Atualizar Lançamento">
                    </div>
                </div>

            </div>
        </form>
    </div>
</div>
</template>

<script>
export default {

}
</script>

<style>

*{
    padding: 0px;
    margin: 0px;
}



.visualizar-cabecalho{
    display: flex;
    flex-direction: row;
    background-color: #121E4B;
    width: 100%;  
}

/* ------------NOME FINSIS---------*/
.visualizar-cabecalho > h3{
    color: #FFFFFF; 
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    margin-left: 1.5%;
    font-size: 35px;
    margin-top: 0.5%;
    margin-bottom: 0.5%;
}

/* --------------NOME BEM VINDO USUARIO-----------------*/
.visualizar-direita{
    color: #FFFFFF; 
    font-family: 'Montserrat', sans-serif;
    text-align: right;
    margin-left: 75%;
    margin-top: 0.5%;
    
}

.visualizar-direita > a{
    color: #FFFFFF;

}

.visualizar-direita > a:hover{
    color: #FFFFFF;
}
/* -----------------------MENU-----------------------*/

.visualizar-menu > ul{  
    margin: 0;
    background-color:rgb(121, 121, 218);
    list-style: none; 
}

.visualizar-menu > ul > li{
    display: inline; 
}

.visualizar-menu > ul > li > a{
    padding: 3px 115px;
    display: inline-block;
    text-decoration: none;
    color: #FFFFFF;  
    font-weight: bold;   
}

.visualizar-menu > ul > li > a:hover{
    color: rgb(121, 121, 218);
}


/* LANÇAMENTO */
.container{
    display: flex;
    flex-direction: column;    
    align-items: center;
    line-height: 20px;
    margin-top: 2%;      
}

.container select{
    width: 250px; /* Tamanho do select, maior que o tamanho da div "div-select" */      
}

.container input{ /* TAMANHO DAS CAIXAS INPUT */
    width: 250px;
    padding: 5px;
}

.col-sm > input{ /* CAIXAS INPUT */
    border-radius: 5px;
    
}

.col-sm > label{ 
    font-family: 'Montserrat', sans-serif;
    margin: 10px;    /* ESPAÇAMENTO DA LABEL DO FORM LANÇAMENTO */
}

.box-actions{ /*  DISTÂNCIAS DOS BOTÕES DO FORM LANCAMENTO PARA OS INPUS */
    margin-top: 15px; 
    text-align: center;
}
.box-actions > input{
    width: 300px; /* TAMANHO DOS INPUTS DOS BOTOES */
    border-radius: 5px;
    
}

.visualizar-bordaFormulario{
    border: 1px solid; 
    border-color: #DCDCDC;
    padding: 10px;
    background-color: #DCDCDC;
    border-radius: 10px;
}

.visualizar-bordaFormulario > h4{
    font-size: 25px ;
    margin-bottom: 25px;
    text-align: center;
    font-weight: bolder;
    font-family: 'Montserrat', sans-serif;
}
/* ----------------------------------------------*/

table{
    margin-top: 5%;
    margin-left: 15%;
}


</style>