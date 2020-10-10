<template>
    <div>
        <div class="configuracoes-cabecalho">
            <h3>SisFis</h3>
        
            <div class="configuracoes-direita">
                <h6>Bem Vindo, usuário!</h6>
                <a href="/login">Sair</a>
            </div>
        </div>
        
            <div class="configuracoes-menu">
                <ul>
                    <li><a href="/index">Página Inicial</a></li>
                    <li><a href="/lancamento">Lançamentos</a></li>
                    <li><a href="/perfis">Perfis</a></li>
                    <li><a href="/configuracoes">Configurações</a></li>
                </ul>
            </div>
           
            <div class="container">
                <form method="POST">
                    <div class="configuracoes-bordaFormulario">
                        <h4>Dados de Acesso</h4>

                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="nome">Nome:</label>
                                    <input name="nome" type="text" placeholder="Ex: Maria" class="form-control" id="nome">
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-lg-6">
                                    <label for="email">Email: </label>
                                    <input name="email" type="email" placeholder="Ex: mariaalves@gmail.com" class="form-control" id="email"/>
                                </div>   
                            </div>

                        <div class="row">
                            <div class="form-group col-lg-6">
                                <label for="senha">Senha:</label>
                                <input name="senha" type="password" class="form-control" id="Senha" />
                            </div>
                        
                            <div class="botao">                                    
                                <input type="button" name="confirmar" value="CONFIRMAR" onclick=" validarDados()" >
                                <input type="reset" name="Limpar" value="LIMPAR DADOS">
                            </div>
                        </div>  
                    </div>
                </form>
            </div>
    </div>
</template>

<script>
export default {};
</script>

<style>

*{
    padding: 0px;
    margin: 0px;
}
.configuracoes-cabecalho{
    display: flex;
    flex-direction: row;
    background-color: #121E4B;
    width: 100%;  
}


/* --------------NOME BEM VINDO USUARIO-----------------*/
.configuracoes-direita{
    color: #FFFFFF; 
    font-family: 'Montserrat', sans-serif;
    text-align: right;
    margin-left: 75%;
    margin-top: 0.5%;
    
}

.configuracoes-direita > a{
    color: #FFFFFF;

}

.configuracoes-direita > a:hover{
    color: #FFFFFF;
}
/* -----------------------MENU-----------------------*/
.configuracoes-menu > ul{  
    margin: 0;
    background-color:rgb(121, 121, 218);
    list-style: none; 
}

.configuracoes-menu > ul > li{
    display: inline; 
}

.configuracoes-menu > ul > li > a{
    padding: 3px 115px;
    display: inline-block;
    text-decoration: none;
    color: #FFFFFF;  
    font-weight: bold;   
}

.configuracoes-menu > ul > li > a:hover{
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
    width: 300px; /* Tamanho do select, maior que o tamanho da div "div-select" */      
}

.container input{ /* TAMANHO DAS CAIXAS INPUT */
    width: 300px;
    padding: 5px;
}

.form-group > input{ /* CAIXAS INPUT */
    border-radius: 5px;
    
}

.form-group > label{ 
    font-family: 'Montserrat', sans-serif;
    margin: 0px;    /* ESPAÇAMENTO DA LABEL DO FORM LANÇAMENTO */
}

.box-actions{ /*  DISTÂNCIAS DOS BOTÕES DO FORM LANCAMENTO PARA OS INPUS */
    margin-top: 30px; 
}
.box-actions > input{
    width: 320px; /* TAMANHO DOS INPUTS DOS BOTOES */
    border-radius: 5px;
}

.configuracoes-bordaFormulario{
    border: 1px solid; 
    border-color: #dcdcdc;
    padding: 20px;
    background-color: #DCDCDC;
    border-radius: 20px;
}

.configuracoes-bordaFormulario > h4{
    font-size: 35px ;
    margin-bottom: 30px;
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