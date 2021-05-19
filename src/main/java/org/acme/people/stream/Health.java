package org.acme.people.stream;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;


@ApplicationScoped
public class Health {

   

	// Retrieving from topic
    @Incoming("heartrate")               
    @Outgoing("heart-rate-stream")      
    @Broadcast                       
    public String process(String name) {
        
        return name ;
    }
    
    @Incoming("bloodoxygen")               
    @Outgoing("blood-oxygen-stream")      
    @Broadcast                       
    public String processtwo(String name) {
        return   name;
    }
    @Incoming("bloodpressure")               
    @Outgoing("blood-pressure-stream")      
    @Broadcast                       
    public String processthree(String name) {
        return name ;
    }
  
}