package com.zepto.notification.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.notification.entity.Notification;
import com.zepto.notification.repository.NotificationRepository;

import jakarta.annotation.PostConstruct;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	KafkaConsumer<String, String> consumer;
	
	@PostConstruct
	public void startConsumer() {
	    createNotification();
	}
	
	public void createNotification() {
		 
		System.out.println("createNotification started");
    	// 3. subscribe to a topic
    	//For a single topic:
    	//consumer.subscribe(Collections.singletonList("notification"));
    	
    	Collection<String> topicsList = Arrays.asList("order-events");
    	consumer.subscribe(topicsList);
    	
    	//So application is always up and running
    	while(true) {
    		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
    		for(ConsumerRecord<String, String> record : records) {
    			System.out.println("message offset: " + record.offset());
    			System.out.println("message key: " + record.key());
    			System.out.println("message value: " + record.value());
    			
    			Notification notification = new Notification();
    			String[] msg = record.value().split(",");
        		notification.setOrderId(msg[0]);
        		notification.setCustomerId(msg[1]);
        		notification.setPaymentStatus(msg[2]);
        		
        		notificationRepository.save(notification);
    			
    		}
    		
    		
    		
    	}
    	
    	
    	
	}
	
}
