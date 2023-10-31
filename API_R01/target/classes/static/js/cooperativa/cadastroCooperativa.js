const input_nome = document.getElementById("nome");
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
        cadastrarCooperativa();
    });
});

async function cadastrarCooperativa(){
    let nome =      input_nome.value;
    let email =     input_email.value;
    let password =  input_password.value;
    let telefone =  input_telefone.value;
    let cnpj =      input_cnpj.value;

    let logradouro =    input_logradouro.value;
    let bairro =        input_bairro.value;
    let cep =           input_cep.value;
    let cidade =        input_cidade.value;
    let uf =            input_uf.value;
    let complemento =   input_complemento.value;
    let numero =        input_numero.value;

    // montando o objeto da cooperativa
    let cooperativa = {
        nome: nome,
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

    await fetch('http://localhost:8080/cooperativa', {
        mode: 'cors',
        method: 'POST',
        headers: headers,
        body: JSON.stringify(cooperativa)
    })
    .then(response => {
        if (response.ok) {
            alert('Cooperativa cadastrada com sucesso!');
            location.reload();
        } else {
            alert('Erro ao cadastrar cooperativa.');
        }
    })
    .catch(error => {
        console.error('Erro ao realizar a solicitação:', error);
    });
}