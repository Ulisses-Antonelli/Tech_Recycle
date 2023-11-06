const array_inputs = []; // para facilitar nossa vida na hora de autenticar os dados, vamos guardar os inputs num array.

// NOME
const input_nome = document.getElementById("nome");
array_inputs.push(input_nome);
input_nome.setAttribute('maxlength','200');

// CNPJ
const input_cnpj = document.getElementById("cnpj");
array_inputs.push(input_cnpj);
input_cnpj.setAttribute('maxlength','14');

// CEP
const input_cep = document.getElementById("cep");
array_inputs.push(input_cep);
input_cep.setAttribute('maxlength','8');
adicionarRegex(input_cep, "^[0-9]*$");

// LOGRADOURO
const input_logradouro = document.getElementById("logradouro");
array_inputs.push(input_logradouro);
input_logradouro.setAttribute('maxlength','200')

// NUMERO
const input_numero = document.getElementById("numero");
array_inputs.push(input_numero);
input_numero.setAttribute('maxlength','7')
adicionarRegex(input_numero, "^[0-9]*$");

// COMPLEMENTO
const input_complemento = document.getElementById("complemento");
array_inputs.push(input_complemento);
input_complemento.setAttribute('maxlength','200')

// BAIRRO
const input_bairro = document.getElementById("bairro");
array_inputs.push(input_bairro);
input_bairro.setAttribute('maxlength','200')

// CIDADE
const input_cidade = document.getElementById("cidade");
array_inputs.push(input_cidade);
input_cidade.setAttribute('maxlength','200')

// UF
const input_uf = document.getElementById("uf");
array_inputs.push(input_uf);

// TELEFONE
const input_telefone = document.getElementById("telefone");
array_inputs.push(input_telefone);
input_telefone.setAttribute('maxlength','11');
adicionarRegex(input_telefone, "^[0-9]*$")

// EMAIL
const input_email = document.getElementById("email");
array_inputs.push(input_email);
input_email.setAttribute('maxlength','200')

// SENHA
const input_password = document.getElementById("password");
array_inputs.push(input_password);
input_password.setAttribute('maxlength','64')

const btn_submit = document.getElementById("submit");

document.addEventListener('DOMContentLoaded', async function () {
    btn_submit.addEventListener("click", (e) => {
        e.preventDefault();
        cadastrarCooperativa();
    });
});

async function cadastrarCooperativa(){
    // verificação de campo vazio em todos os inputs. Throw new error quebra a function e evita o fetch que vai dar erro
    array_inputs.forEach(input => {
        if (isCampoVazio(input)){
            notificar("O Campo \""+input.getAttribute('placeholder')+"\" está Vazio","erro");
            throw new Error("Existem Campos Vázios no Formulário");
        };
    });

    // verificação de tamanho
    if(!hasTamanhoDesejado(input_cep, 8)){
        notificar("CEP inválido. Faltam dígitos","erro");
        throw new Error("Campo CEP invalido")
    }

    // montando o objeto da cooperativa
    let cooperativa = {
        nome: input_nome.value,
        telefone: input_telefone.value,
        cnpj: input_cnpj.value,
        endereco: {
            logradouro: input_logradouro.value,
            bairro: input_bairro.value,
            cep: input_cep.value,
            cidade: input_cidade.value,
            uf: input_uf.value,
            complemento: input_complemento.value,
            numero: input_numero.value
        },
        credenciais: {
            email: input_email.value,
            password: input_password.value
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
            notificar('Cooperativa cadastrada com sucesso!','sucesso');
            setTimeout( () => {
                location.reload();
            },5000);
        } else {
            notificar('Erro ao cadastrar cooperativa.','erro');
        }
    })
    .catch(error => {
        console.error('Erro ao realizar a solicitação:', error);
    });
}

function isCampoVazio(input){
    if(input.value == "" || input.value == null){
        input.style.outline = "2px solid #FF0000"
        return true;
    } else {
        input.style.outline = "none"
        return false;
    }
}

function hasTamanhoDesejado(input, tamanho){
    if(input.value.length == tamanho){
        input.style.outline = "none"
        return true;
    } else {
        input.style.outline = "2px solid #FF0000"
        return false;
    }
}

function isCepValido(cep){

}

function adicionarRegex(input, valor_regex){
    input.addEventListener('beforeinput', (e) => {
        let regex = new RegExp(valor_regex);
    
        if(e.data != null && !regex.test(e.data)){
            e.preventDefault();
        }
    });
}