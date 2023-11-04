import { redirecionarPagina } from './RedirecionarPagina.js';

document.addEventListener('DOMContentLoaded', function () {
    const loginButton = document.getElementById('fazerLogin');

    loginButton.addEventListener('click',()=>{
        logarUsuario();
    });
});


async function logarUsuario() {
    let email = document.getElementById('email').value;
    let password = document.getElementById('password').value;
    
    let credenciais = {
        email: email,
        password: password
    };

    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(credenciais)
        });

        if (response.ok) {
            setTimeout(() => {
                modal.style.display = 'none';
                redirecionarPagina();
                document.getElementById('login-form').reset();
            }, 5500);

        } else {
            alert('Erro ao inserir credenciais.');
        }
    } catch (error) {
        console.error('Erro ao realizar a solicitação:', error);
    }
}




