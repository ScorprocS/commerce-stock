package lu.sfeir.commerce.stocks.events;

import org.apache.kafka.common.serialization.Serializer;
//import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StockUpdatedSerializer implements Serializer<StockUpdated>{

	@Autowired
	private ObjectMapper objectMapper;


	@Override
	public byte[] serialize(String topic, StockUpdated data) {
		
		try {
			return objectMapper.writeValueAsBytes(data);
		}catch(Exception e) {
			
		}
		return null;
	}

}
