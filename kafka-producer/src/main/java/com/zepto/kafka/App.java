package com.zepto.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ExecutionException
    {
        
    	// 1) bootstrap servers + k/v serialization config
    	Properties prop = new Properties();
    	prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	// 2) Create kafka Producer
    	KafkaProducer producer = new KafkaProducer(prop);
    	
    	for(int i =0; i< 30;i++) {
    		// 3) Create record/ message
        	ProducerRecord record = new ProducerRecord("notification", "notification"+i, "1111"+i);
        	
        	// 4. send the message to the broker
        	
        	Future<RecordMetadata> recordMetadata = producer.send(record);
        	System.out.println("partititon: " + recordMetadata.get().partition());
        	System.out.println("offset: " + recordMetadata.get().offset());
        	
    	}
    	
    	System.out.println("All message sent successfully");
    	
    	producer.flush(); // Forces any buffered records to be sent immediately
    	producer.close(); // Flushes and cleans up resources
    	
    }
}
