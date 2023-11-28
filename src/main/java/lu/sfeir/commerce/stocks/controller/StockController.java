package lu.sfeir.commerce.stocks.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lu.sfeir.commerce.stocks.entity.Stock;
import lu.sfeir.commerce.stocks.services.StockService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stocks")
public class StockController {

	private final StockService stockService;
	
	@GetMapping("")
	public ResponseEntity<List<Stock>> getAllProductWithStock(){
		return ResponseEntity.ok(stockService.getAll());
		
	}
}
