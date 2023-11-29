package lu.sfeir.commerce.stocks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import lu.sfeir.commerce.stocks.dto.StockDto;
import lu.sfeir.commerce.stocks.entity.Stock;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StockDtoMapper {

	StockDto map(Stock stock);
	
	@Mapping(target = "id", ignore = true)
	Stock map(@MappingTarget Stock stock, StockDto stockDto);
	
	default Stock map(StockDto stockDto) {
		return map(new Stock(), stockDto);
	}

}
