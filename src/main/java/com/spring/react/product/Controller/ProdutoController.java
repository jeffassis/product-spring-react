package com.spring.react.product.Controller;

import com.spring.react.product.Service.ProdutoService;
import com.spring.react.product.model.ProdutoModel;
import com.spring.react.product.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping("/listar")
    public Iterable<ProdutoModel> listar() {
        return service.listar();
    }

    @GetMapping("/")
    public String rota() {
        return "API de produtos funcionando!";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel produtoModel) {
        return service.cadastrarAlterar(produtoModel, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModel produtoModel) {
        return service.cadastrarAlterar(produtoModel, "alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<ResponseModel> remover(@PathVariable long id) {
        return service.remover(id);
    }
}
