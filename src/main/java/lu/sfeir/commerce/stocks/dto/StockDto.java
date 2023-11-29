package lu.sfeir.commerce.stocks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {
	
	private Long id;
	
	private Long productId;
	
	private Long numberAvailable;
	
}
		