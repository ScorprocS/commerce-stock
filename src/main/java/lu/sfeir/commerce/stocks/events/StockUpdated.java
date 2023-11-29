package lu.sfeir.commerce.stocks.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockUpdated {
	
	private Long productId;
	private Long oldNumberavailable;
	private Long numberAvailable;

}
