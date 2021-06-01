package org.acme.people.stream;

import java.time.Duration;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class VitalsGenerator {

	private Random random = new Random();
	
	
	//Publisher Sending messages to the kafka topic 
    @Outgoing("heartrate")           
    public Multi<Record<String, Integer>> generate() {  
        return Multi.createFrom().ticks().every(Duration.ofSeconds(10)).onOverflow().drop()
        		 .map(tick -> {
        			 String name =NameGenerator.generate();
        			 Integer heartrate =random.nextInt(120);
                     System.err.println(name+" "+heartrate);
                     return Record.of(name, heartrate);
        		 });
    }
    
    
   

}