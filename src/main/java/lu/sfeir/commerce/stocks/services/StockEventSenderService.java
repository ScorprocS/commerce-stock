package lu.sfeir.commerce.stocks.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lu.sfeir.commerce.stocks.events.StockUpdated;

@Service
@RequiredArgsConstructor
public class StockEventSenderService {
	@Value("${kafka.topicName}")
	private String topicName;

	private final KafkaTemplate<String, StockUpdated> kafkaTemplate;

	public void sendEvent(StockUpdated event) {
		CompletableFuture<SendResult<String, StockUpdated>> future = kafkaTemplate.send(topicName, event);
		future.whenComplete((result, ex) -> {
	         if (ex == null) {
	             System.out.println("Sent message=[" + event + 
	                 "] with offset=[" + result.getRecordMetadata().offset() + "]");
	         } else {
	             System.out.println("Unable to send message=[" + 
	            		event + "] due to : " + ex.getMessage());
	         }
	     });
	}
}
