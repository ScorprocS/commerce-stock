package lu.sfeir.commerce.stocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lu.sfeir.commerce.stocks.dto.StockDto;
import lu.sfeir.commerce.stocks.entity.Stock;
import lu.sfeir.commerce.stocks.events.StockUpdated;
import lu.sfeir.commerce.stocks.exception.EntityNotFoundException;
import lu.sfeir.commerce.stocks.exception.InvalidParameterException;
import lu.sfeir.commerce.stocks.mapper.StockDtoMapper;
import lu.sfeir.commerce.stocks.repository.StockRepository;

@Service
@RequiredArgsConstructor
public class StockService {
	private final StockRepository stockRepository;
	private final StockEventSenderService stockEventSenderService;
	private final StockDtoMapper stockDtoMapper;

	public List<StockDto> getAll() {
		return stockRepository.findAll().stream().map(stockDtoMapper::map).toList();
	}

	public StockDto create(StockDto stockDto) {
		Stock savedStock = stockRepository.save(stockDtoMapper.map(stockDto));
		stockEventSenderService.sendEvent(buildFomEntity(savedStock, null));

		return stockDtoMapper.map(savedStock);
	}

	public StockDto update(Long id, StockDto stockDto) {
		if (id == null) {
			throw new InvalidParameterException("Id should be defined");
		}
		Optional<Stock> oldStockOptional = stockRepository.findById(id);
		Stock oldStock = oldStockOptional
				.orElseThrow(() -> new EntityNotFoundException("Stock with id:" + id + " not found"));
		final long oldNumberavailable = oldStock.getNumberAvailable();
		Stock savedStock = stockRepository.save(stockDtoMapper.map(oldStock, stockDto));

		stockEventSenderService.sendEvent(buildFomEntity(savedStock, oldNumberavailable));

		return stockDtoMapper.map(savedStock);

	}

	private StockUpdated buildFomEntity(@NonNull Stock savedStock, Long oldNumberavailable) {
		StockUpdated stockUpdated = StockUpdated.builder().numberAvailable(savedStock.getNumberAvailable())
				.productId(savedStock.getProductId()).oldNumberavailable(oldNumberavailable).build();

		return stockUpdated;
	}

}
