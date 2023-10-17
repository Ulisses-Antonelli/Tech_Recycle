function deletarUsuario(id){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    fetch('http://localhost:8080/usuario/'+id, {
        mode: 'cors',
        method: 'DELETE',
        headers: headers
    })
    .then(response => {
        if(response.ok) {
            alert('Usuário desativado com sucesso!');
            location.reload();
        } else {
            alert('ERRO ao deletar Usuário');
        }
    })
    .catch(error => {
        console.log('Erro ao realizar a solicitação:', error);
    });
}