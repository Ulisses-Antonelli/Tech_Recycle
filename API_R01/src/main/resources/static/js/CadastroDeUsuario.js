import { redirecionarPagina } from './RedirecionarPagina.js';

document.addEventListener('DOMContentLoaded', function () {
    const cadastrarButton = document.getElementById('cadastrarButton');

    cadastrarButton.addEventListener('click',()=>{
        cadastrarUsuario();
    });
});

async function cadastrarUsuario(evt) {
    let $ = document.getElementById.bind(document);
    let nome = $('nome').value;
    let cpf = $('cpf').value;
    let cep = $('cep').value;
    let logradouro = $('rua').value;
    let numero = $('numero').value;
    let bairro = $('bairro').value;
    let complemento = $('complemento').value;
    let cidade = $('cidade').value;
    let uf = $('uf').value;
    let telefone = $('telefone').value;
    let email = $('email').value;
    let password = $('password').value;
    
    let usuario = {
        nome: nome,
        telefone: telefone,
        cpf: cpf,
        credenciais: {
            email: email,
            password: password
        },
        endereco: {
            logradouro: logradouro,
            bairro: bairro,
            cep: cep,
            numero: numero,
            complemento: complemento,
            cidade: cidade,
            uf: uf
        }
    };

    try {
        const response = await fetch('http://localhost:8080/usuario', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            setTimeout(() => {
                alert('Usuario cadastrado com sucesso!')
                //document.getElementById('formularioCadastro').reset();
            }, 1500);
            redirecionarPagina();
        } else {
            alert('Erro ao cadastrar usuário.');
        }
    } catch (error) {
        console.error('Erro ao realizar a solicitação:', error);
    }
}
