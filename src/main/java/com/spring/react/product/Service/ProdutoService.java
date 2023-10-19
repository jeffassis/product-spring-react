package com.spring.react.product.Service;

import com.spring.react.product.Repository.ProdutoRepository;
import com.spring.react.product.model.ProdutoModel;
import com.spring.react.product.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ResponseModel responseModel;

    public Iterable<ProdutoModel> listar() {
        return repository.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModel produtoModel, String acao) {
        if (produtoModel.getNome().equals("")) {
            responseModel.setMensagem("O nome do produto é obrigatório!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if (produtoModel.getMarca().equals("")) {
            responseModel.setMensagem("A marca do produto é obrigatória!");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<ProdutoModel>(repository.save(produtoModel), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<ProdutoModel>(repository.save(produtoModel), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ResponseModel> remover(long id) {
        repository.deleteById(id);
        responseModel.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
    }
}
