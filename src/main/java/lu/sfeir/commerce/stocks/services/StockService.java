package lu.sfeir.commerce.stocks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lu.sfeir.commerce.stocks.entity.Stock;
import lu.sfeir.commerce.stocks.repository.StockRepository;

@Service
@RequiredArgsConstructor
public class StockService {
	private final StockRepository stockRepository;
	public List<Stock> getAll() {
		return stockRepository.findAll();
	}

}
