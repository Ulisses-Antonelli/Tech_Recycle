// Função para validar CPF
function validarCPF(cpf) {
    const cpfRegex = /^\d{11}$/;
    return cpfRegex.test(cpf);
  }
  
  // Função para validar CEP
  function validarCEP(cep) {
    const cepRegex = /^\d{8}$/;
    return cepRegex.test(cep);
  }
  
  // Função para validar telefone
  function validarTelefone(telefone) {
    const telefoneRegex = /^\d{10}$/;
    return telefoneRegex.test(telefone);
  }
  
  // Função para validar email
  function validarEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }
  
  // Função para aplicar máscara no CPF
  function formatarCPF(cpf) {
    return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  }
  
  // Função para aplicar máscara no CEP
  function formatarCEP(cep) {
    return cep.replace(/(\d{5})(\d{3})/, '$1-$2');
  }
  
  // Função para aplicar máscara no telefone
  function formatarTelefone(telefone) {
    return telefone.replace(/(\d{2})(\d{4})(\d{4})/, '($1) $2-$3');
  }
  
  // Validação em tempo real da confirmação de senha
  const senhaInput = document.getElementById('password');
  const confirmSenhaInput = document.getElementById('confirmarSenha');
  
  senhaInput.addEventListener('input', () => {
    const senha = senhaInput.value;
    const confirmSenha = confirmSenhaInput.value;
  
    if (senha.length >= 5) {
      senhaInput.classList.remove('is-invalid');
      confirmSenhaInput.removeAttribute('disabled');
    } else {
      senhaInput.classList.add('is-invalid');
      confirmSenhaInput.setAttribute('disabled', true);
    }
  
    if (senha === confirmSenha) {
      confirmSenhaInput.classList.remove('is-invalid');
    } else {
      confirmSenhaInput.classList.add('is-invalid');
    }
  });
  
  // Função para validar todos os campos antes de enviar o formulário
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
  
  // Aplicar máscaras nos campos
  document.getElementById('cpf').addEventListener('input', (e) => {
    e.target.value = formatarCPF(e.target.value.replace(/\D/g, ''));
  });
  
  document.getElementById('cep').addEventListener('input', (e) => {
    e.target.value = formatarCEP(e.target.value.replace(/\D/g, ''));
  });
  
  document.getElementById('telefone').addEventListener('input', (e) => {
    e.target.value = formatarTelefone(e.target.value.replace(/\D/g, ''));
  });
  
  // Adicionar evento de validação ao enviar o formulário
  document.getElementById('formularioCadastro').addEventListener('submit', (e) => {
    if (!validarFormulario()) {
      e.preventDefault(); // Impede o envio do formulário se houver erros
    }
  });
  