const array_inputs_obrigatorios = [];

const input_email = document.getElementById("email");
array_inputs_obrigatorios.push(input_email);
input_email.setAttribute("maxlength", "200");

const input_password = document.getElementById("password");
array_inputs_obrigatorios.push(input_password);
input_password.setAttribute("maxlength", "64");

const btnLogin = document.getElementById("fazerLogin");

document.addEventListener("DOMContentLoaded", function () {

    btnLogin.addEventListener("click", async (e) => {
        try {
            var email_disponivel = await isEmailDisponivel(input_email.value);
            if (email_disponivel) {
                e.preventDefault();
                document.body.style.cursor = "wait";
                btnLogin.style.opacity = "0.7";
                await logarUsuario();

                const usuarioResponse = await obterUsuarioPorEmail(input_email.value);
                localStorage.setItem("usuario", JSON.stringify(usuarioResponse));

            } else {
                notificar("Email não encontrado, por favor cadastre-se no sistema", "erro");
                throw new Error("Email não encontrado");
            }
        } catch (error) {
            error.preventReload = true;
            console.log(error);
            throw error;
        }
    });
});

async function logarUsuario() {
    array_inputs_obrigatorios.forEach((input) => {
        if (isCampoVazio(input)) {
            notificar('O Campo "' + input.getAttribute("placeholder") + '" está Vazio', "erro");
            document.body.style.cursor = "default";
            btnLogin.style.opacity = "1";
            throw new Error("Existem Campos Vázios no Formulário");
        }
    });

    if (!hasTamanhoEntre(input_password, 8, 64)) {
        document.body.style.cursor = "default";
        btnLogin.style.opacity = "1";
        notificar("A senha deve ter no mínimo 8 Caracteres", "erro");
        throw new Error("Senha com tamanho invalido");
    }

    var credenciais = {
        email: input_email.value,
        password: input_password.value,
    };

    let headers = new Headers();
    headers.append("Content-Type", "application/json");
    headers.append("Accept", "application/json");
    headers.append("Origin", "*");

    await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: headers,
        body: JSON.stringify(credenciais),
    })
    .then(async (response) => {
        if (response.ok) {
            document.body.style.cursor = "default";
            btnLogin.style.opacity = "1";
            notificar("Logado com sucesso!", "sucesso");

            let tokenUsuario = await response.json();
            localStorage.setItem("tokenUsuario", JSON.stringify(tokenUsuario));

        } else {
            document.body.style.cursor = "default";
            btnLogin.style.opacity = "1";
            notificar("Erro ao Logar", "erro");
        }
    })
    .catch((error) => {
    document.body.style.cursor = "default";
    btnLogin.style.opacity = "1";
    console.error("Erro ao realizar a solicitação:", error);
    });
}



async function isEmailDisponivel(email) {
    try {
        let headers = new Headers();
        headers.append("Content-Type", "application/json");
        headers.append("Accept", "application/json");
        headers.append("Origin", "*");

        let email_disp = await fetch("http://localhost:8080/usuario/porEmail/" + email, {
        method: "GET",
        headers: headers,
        });
        if (!email_disp.ok) {
        throw new Error("Erro na requisição");
        }
        var data = email_disp.json();
        return data;
    } catch (error) {
        console.error("Erro na Requisição:", error);
        return false;
    }
}

async function obterUsuarioPorEmail(email) {
    try {
        let headers = new Headers();
        headers.append("Content-Type", "application/json");
        headers.append("Accept", "application/json");
        headers.append("Origin", "*");

        let response = await fetch('http://localhost:8080/usuario/usuarioPorEmail/' + email, {
            method: 'GET',
            headers: headers,
        });

        if (!response.ok) {
            throw new Error("Erro na requisição");
        }

        let usuario = await response.json();
        return usuario;

    } catch (error) {
        console.error("Erro ao obter usuário por email:", error);
        throw error;
    }
}

function isCampoVazio(input) {
    if (input.value == "" || input.value == null) {
        input.style.outline = "2px solid #FF0000";
        return true;
    } else {
        input.style.outline = "none";
        return false;
    }
}

function hasTamanhoEntre(input, tamanho_min, tamanho_max) {
    if (input.value.length >= tamanho_min && input.value.length <= tamanho_max) {
        input.style.outline = "none";
        return true;
    } else {
        input.style.outline = "2px solid #FF0000";
        return false;
    }
}

const usuarioArmazenado = localStorage.getItem('usuario');
if (usuarioArmazenado) {

    const usuario = JSON.parse(usuarioArmazenado);

    console.log('ID do usuário:', usuario.id);
    console.log('Nome do usuário:', usuario.nome);
    console.log('Email do usuário:', usuario.email);

} else {
    console.log('Nenhum usuário encontrado na localStorage');
}