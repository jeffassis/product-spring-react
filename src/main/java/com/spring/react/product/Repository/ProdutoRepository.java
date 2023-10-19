package com.spring.react.product.Repository;

import com.spring.react.product.model.ProdutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long> {
}
