const TBL_CORPO = document.getElementById('tbl-corpo');

document.addEventListener('DOMContentLoaded', async function () {

    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    headers.append('Origin', '*');

    await fetch('http://localhost:8080/cooperativa', {
        mode: 'cors',
        method: 'GET',
        headers: headers
    }).then(data => {
        return data.json()
    }).then(dados => {
        let cooperativas = dados.content;

        cooperativas.forEach(coop =>{
            const elem_tr = document.createElement('tr');
        
            const elem_td_id = document.createElement('td');
            const elem_td_nome = document.createElement('td');
            const elem_td_email = document.createElement('td');
            const elem_td_cnpj = document.createElement('td');

            const elem_td_update = document.createElement('td');
            const elem_a_update = document.createElement('a')

            const elem_td_delete = document.createElement('td');
            const elem_a_delete = document.createElement('a')

            elem_td_id.textContent = coop.id;
            elem_td_id.classList.add("d-flex", "align-self-center")
            elem_tr.append(elem_td_id);
            
            elem_td_nome.textContent = coop.nome;
            elem_tr.append(elem_td_nome);

            elem_td_email.textContent = coop.email;
            elem_tr.append(elem_td_email);

            elem_td_cnpj.textContent = coop.cnpj;
            elem_tr.append(elem_td_cnpj);

            /* UPDATE */
            elem_a_update.textContent = "Alterar Dados"; // criando o <a href="..."> </a> 
            elem_a_update.classList.add("btn", "py-0", "btn-outline-dark");
            elem_a_update.setAttribute("href","../../templates/cooperativas/alterarCooperativa.html?id="+coop.id) // colocando o <a> dentro do <td>
            elem_td_update.append(elem_a_update); // colocando o <td><a href="..."></a></td> dentro do <tr>
            elem_tr.append(elem_td_update);

            /* DELETE */
            elem_a_delete.textContent = "Desativar"; // definindo o <a href="..."> </a> 
            elem_a_delete.classList.add("delete","btn", "py-0", "btn-outline-danger");
            elem_a_delete.setAttribute("data-id", coop.id);
            elem_a_delete.addEventListener("click", (e) => {
                deletarCooperativa(coop.id);
            });
            elem_td_delete.append(elem_a_delete); // colocando o <a> dentro do <td>
            elem_tr.append(elem_td_delete); // colocando o <td><a href="..."></a></td> dentro do <tr>


            // colocando nosso <tr> no corpo da tabela
            TBL_CORPO.append(elem_tr);            
        })
        
    })
});