function salvarProduto(){
    const data = {
        nome: document.querySelector('#nomeProduto').value,
        valor: document.querySelector('#valorProduto').value,
        categoria: document.querySelector('#categoriaProduto').value,
        lote: document.querySelector('#loteProduto').value,
        fornecedor: document.querySelector('#fornecedorProduto').value,
    };
    
    const url = 'http://localhost:8080/produto';
    const options = {
        method: 'POST',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };
    fetch(url,options).then((data) => {
        let tbody = document.getElementById('table-tbody');
        tbody.remove()

        buscarProduto();
    });
}