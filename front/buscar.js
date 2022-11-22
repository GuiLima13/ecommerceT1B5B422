function buscarProduto(){
    const url = 'http://localhost:8080/produto';
    const options = {
        method: 'GET'
    }
    fetch(url, options)
    .then(response => response.json())
    .then(data => {
        var tbody =document.createElement('tbody');

        tbody.id = "table-tbody"
    

        data.map(resp => {
            let tr = document.createElement('tr');

            let tdNome = document.createElement('td');
            let tdCategoria = document.createElement('td');
            let tdLote = document.createElement('td');
            let tdFornecedor = document.createElement('td');
            let tdValor = document.createElement('td');

            tdNome.innerHTML = resp.nome;
            tdCategoria.innerHTML = resp.categoria;
            tdLote.innerHTML = resp.lote;
            tdFornecedor.innerHTML = resp.fornecedor;
            tdValor.innerHTML = resp.valor;

            tr.appendChild(tdNome);
            tr.appendChild(tdCategoria);
            tr.appendChild(tdLote);
            tr.appendChild(tdFornecedor);
            tr.appendChild(tdValor);

            tbody.appendChild(tr);

        })

        
        document.getElementById('table-produto').appendChild(tbody)
    })
}

window.onload = function (){
    buscarProduto();
}