package com.zepto;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class App 
{
    public static void main( String[] args )
    {
        
    	// 1. kafka consumer config
    	Properties prop = new Properties();
    	prop.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	prop.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "notification-g-1");
    	prop.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	prop.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	
    	// 2. create a consumer & pass the config || <Key, Value>
    	KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
    	
    	// 3. subscribe to a topic
    	//For a single topic:
    	//consumer.subscribe(Collections.singletonList("notification"));
    	
    	Collection<String> topicsList = Arrays.asList("notification");
    	consumer.subscribe(topicsList);
    	
    	//So application is always up and running
    	while(true) {
    		ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
    		for(ConsumerRecord<String, String> record : records) {
    			System.out.println("message offset: " + record.offset());
    			System.out.println("message key: " + record.key());
    			System.out.println("message value: " + record.value());
    		}
    	}
    	
    	
    }
}
