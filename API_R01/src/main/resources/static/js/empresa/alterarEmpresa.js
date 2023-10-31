const urlParams = new URLSearchParams(window.location.search);
const param_id = urlParams.get('id');
console.log(param_id);

const input_nome = document.getElementById("nome");
const input_segmento = document.getElementById("tipoEstabelecimento")
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

    fetch('http://localhost:8080/empresa/'+param_id, {
        mode: 'cors',
        method: 'GET',
        headers: headers
    })
    .then(data => {
        return data.json()
    })
    .then(empresa => {
        input_nome.value =          empresa.estabelecimento;
        input_segmento.value =      empresa.tipoEstabelecimento
        input_cnpj.value =          empresa.cnpj;
        input_cep.value =           empresa.endereco.cep;
        input_logradouro.value =    empresa.endereco.logradouro;
        input_numero.value =        empresa.endereco.numero;
        input_complemento.value =   empresa.endereco.complemento;
        input_bairro.value =        empresa.endereco.bairro;
        input_cidade.value =        empresa.endereco.cidade;
        input_uf.value =            empresa.endereco.uf;
        input_telefone.value =      empresa.telefone;
        input_email.value =         empresa.email;
        // input_password.value =   empresa.password
    });

    btn_submit.addEventListener("click", (e) => {
        e.preventDefault();
        alterarEmpresa();
    });
});

function alterarEmpresa(){

    let json_dados = {
        id: parseInt(param_id),
        estabelecimento: input_nome.value,
        tipoEstabelecimento: input_segmento.value,
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

    fetch('http://localhost:8080/empresa/'+param_id, {
        mode: 'cors',
        method: 'PUT',
        headers: headers,
        body: JSON.stringify(json_dados)
    })
    .then(response => {
        if(response.ok) {
            alert('empresa alterada com sucesso!');
            location.reload();
        } else {
            alert('ERRO ao alterar empresa');
        }
    })
    .catch(error => {
        console.log('Erro ao realizar a solicitação:', error);
    });

}