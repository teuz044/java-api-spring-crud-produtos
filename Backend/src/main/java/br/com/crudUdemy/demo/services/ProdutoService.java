package br.com.crudUdemy.demo.services;

import br.com.crudUdemy.demo.model.Produto;
import br.com.crudUdemy.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
@Autowired
private ProdutoRepository repository;


public List<Produto> obterTodos() {
    List<Produto> lista = repository.findAll();
    return lista;
}
public Produto obterPorId(Integer id) {
    Optional<Produto> produtoOptional = repository.findById(id);
    return produtoOptional.orElse(null);
}
public Produto adicionarProduto (Produto produto) {
    Produto produtoNovo = repository.save(produto);
    return produto;
}
public Produto alterarProduto (Produto produto) {
    Produto produtoAlterado = repository.save(produto);
    return produto;
}

public Boolean deletarProduto (Integer id) {
    repository.deleteById(id);
    return true;
}

}
