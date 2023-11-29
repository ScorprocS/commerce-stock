package lu.sfeir.commerce.stocks.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lu.sfeir.commerce.stocks.dto.StockDto;
import lu.sfeir.commerce.stocks.services.StockService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stocks")
public class StockController {

	private final StockService stockService;
	
	@GetMapping(value = {"","/"})
	public ResponseEntity<List<StockDto>> getAllProductWithStock(){
		return ResponseEntity.ok(stockService.getAll());
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<StockDto> updateStock(@PathVariable("id") Long id,@RequestBody StockDto stockDto){
		return ResponseEntity.ok(stockService.update(id, stockDto));
	}
}
