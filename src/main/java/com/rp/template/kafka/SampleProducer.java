package com.rp.template.kafka;

import com.newegg.ec.solr.subscriber.Constants;
import com.newegg.ec.solr.subscriber.config.LoadKafkaConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.inject.Singleton;
import java.util.Properties;

@Singleton
public class SampleProducer {
	private static KafkaProducer<String, String> producer;

	static {
		LoadKafkaConfig loadKafkaConfig = Constants.getLoadKafkaConfig();
		Properties props = loadKafkaConfig.getKafkaConfig().getProperties();
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		producer = new KafkaProducer<>(props);
	}

	public static KafkaProducer<String, String> getInstance() {
		return producer;
	}

	public void send(ProducerRecord producerRecord){
		producer.send(producerRecord);
	}

	public void flush(){
		producer.flush();
	}

	public void closeProducer() {
		producer.close();
	}
}
