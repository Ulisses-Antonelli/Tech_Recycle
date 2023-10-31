const input_nome = document.getElementById("nome");
const input_segmento = document.getElementById("segmento")
const input_cnpj = document.getElementById("cnpj");
const input_cep = document.getElementById("cep");
const input_logradouro = document.getElementById("logradouro");
const input_numero = document.getElementById("numero");
const input_complemento = document.getElementById("complemento");
const input_bairro = document.getElementById("bairro");
const input_cidade = document.getElementById("cidade");
const input_uf = document.getElementById("uf");
const input_telefone = document.getElementById("telefone");
const input_email = document.getElementById("email");
const input_password = document.getElementById("password");

const btn_submit = document.getElementById("submit");

document.addEventListener('DOMContentLoaded', async function () {
    btn_submit.addEventListener("click", (e) => {
        e.preventDefault();
        cadastrarEmpresa();
    });
});

async function cadastrarEmpresa(){
    /*
    if(input_nome.value == null || input_nome.value == ""){
        input_nome.style.outline = "2px solid #FF0000"
        return;
    } else {
        
    }
    */
   
    isCampoVazio(input_nome);
    let estabelecimento = input_nome.value;

    isCampoVazio(input_segmento);
    let segmento = input_segmento.value;

    isCampoVazio(input_email);
    let email = input_email.value;

    isCampoVazio(input_password);
    let password = input_password.value;

    isCampoVazio(input_telefone);
    let telefone = input_telefone.value;

    isCampoVazio(input_cnpj);
    let cnpj = input_cnpj.value;

    isCampoVazio(input_logradouro);
    let logradouro = input_logradouro.value;

    isCampoVazio(input_bairro);
    let bairro = input_bairro.value;

    isCampoVazio(input_cep);
    let cep = input_cep.value;

    isCampoVazio(input_cidade);
    let cidade = input_cidade.value;

    isCampoVazio(input_uf);
    let uf = input_uf.value;

    isCampoVazio(input_complemento);
    let complemento = input_complemento.value;

    isCampoVazio(input_numero);
    let numero = input_numero.value;

    // tratamento de erros
    // montando o objeto da empresa
    let empresa = {
        estabelecimento: estabelecimento,
        tipoEstabelecimento: segmento,
        telefone: telefone,
        cnpj: cnpj,
        endereco: {
            logradouro: logradouro,
            bairro: bairro,
            cep: cep,
            cidade: cidade,
            uf: uf,
            complemento: complemento,
            numero: numero
        },
        credenciais: {
            email: email,
            password: password
        }
    };

    // preparando requisição
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    await fetch('http://localhost:8080/empresa', {
        mode: 'cors',
        method: 'POST',
        headers: headers,
        body: JSON.stringify(empresa)
    })
    .then(response => {
        if (response.ok) {
            alert('Empresa cadastrada com sucesso!');
            location.reload();
        } else {
            alert('Erro ao cadastrar Empresa.');
        }
    })
    .catch(error => {
        console.error('Erro ao realizar a solicitação:', error);
    });
}

function isCampoVazio(input){
    if(input.value == "" || input.value == null){
        input.style.outline = "2px solid #FF0000"
        return;
    } else {
        input.style.outline = "none"
    }
}