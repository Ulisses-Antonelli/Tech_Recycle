const form      = document.getElementById('formularioCadastro');
const spans     = document.querySelectorAll('.span-required');



  

  


  

  

  



function validarEntradas(campoValue, tipoValue){

    const regexMap = {
        cep: /^\d{8}$/,
        cpf: /^\d{11}$/,
        telefone: /^\d{10}$/,
        email: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    };

    if (regexMap[tipo]) {
        return regexMap[tipo].test(valor);
    } else {
        console.error("Tipo de validação inválido");
        return false;
    }
}

function validarFormulario() {
    const nome = document.getElementById('nome').value;
    const cpf = document.getElementById('cpf').value;
    const cep = document.getElementById('cep').value;
    const telefone = document.getElementById('telefone').value;
    const email = document.getElementById('email').value;
  
    if (nome.trim() === '' || !validarCPF(cpf) || !validarCEP(cep) || !validarTelefone(telefone) || !validarEmail(email)) {
      alert('Por favor, preencha todos os campos corretamente.');
      return false;
    }
    return true;
}




form.addEventListener('submit', (e) => {
    if (!validarFormulario()) {
      e.preventDefault();
    }
});