function deletarCooperativa(id){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    fetch('http://localhost:8080/cooperativa/'+id, {
        mode: 'cors',
        method: 'DELETE',
        headers: headers
    })
    .then(response => {
        if(response.ok) {
            alert('Cooperativa desativado com sucesso!');
            location.reload();
        } else {
            alert('ERRO ao deletar Cooperativa');
        }
    })
    .catch(error => {
        console.log('Erro ao realizar a solicitação:', error);
    });
}