package lu.sfeir.commerce.stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lu.sfeir.commerce.stocks.entity.Stock;

//@RepositoryRestResource(collectionResourceRel = "stocks", path = "stocks")
public interface StockRepository  extends JpaRepository<Stock,Long>{

}
