const urlParams = new URLSearchParams(window.location.search);
const param_id = urlParams.get('id');
console.log(param_id);

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
// const input_email = document.getElementById("email");
// const input_password = document.getElementById("password");
// const input_conf_password = document.getElementById();

const btn_submit = document.getElementById("submit");

document.addEventListener('DOMContentLoaded', function () {    
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    fetch('http://localhost:8080/cooperativa/'+param_id, {
        mode: 'cors',
        method: 'GET',
        headers: headers
    })
    .then(data => {
        return data.json()
    })
    .then(cooperativa => {
        input_nome.value =          cooperativa.nome;
        input_cnpj.value =          cooperativa.cnpj;
        input_cep.value =           cooperativa.endereco.cep;
        input_logradouro.value =    cooperativa.endereco.logradouro;
        input_numero.value =        cooperativa.endereco.numero;
        input_complemento.value =   cooperativa.endereco.complemento;
        input_bairro.value =        cooperativa.endereco.bairro;
        input_cidade.value =        cooperativa.endereco.cidade;
        input_uf.value =            cooperativa.endereco.uf;
        input_telefone.value =      cooperativa.telefone;
        input_email.value =         cooperativa.email;
        // input_password.value =   cooperativa.password
    });

    btn_submit.addEventListener("click", (e) => {
        e.preventDefault();
        alterarCooperativa();
    });
});

function alterarCooperativa(){

    let json_dados = {
        id: parseInt(param_id),
        nome: input_nome.value,
        telefone: input_telefone.value,
        cnpj: input_cnpj.value,
        endereco: {
            logradouro: input_logradouro.value,
            bairro: input_bairro.value,
            cep: input_cep.value,
            numero: input_numero.value,
            complemento: input_complemento.value,
            cidade: input_cidade.value,
            uf: input_uf.value
        }
    }

    //fazendo o fetch
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    fetch('http://localhost:8080/cooperativa/'+param_id, {
        mode: 'cors',
        method: 'PUT',
        headers: headers,
        body: JSON.stringify(json_dados)
    })
    .then(response => {
        if(response.ok) {
            alert('Cooperativa alterada com sucesso!');
            location.reload();
        } else {
            alert('ERRO ao alterar Cooperativa');
        }
    })
    .catch(error => {
        console.log('Erro ao realizar a solicitação:', error);
    });

}