package org.acme.people.stream;

import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

@ApplicationScoped
public class VitalsGenerator {

	//Publisher Sending messages to the kafka topic 
    @Outgoing("generated-heart-name")           
    public Flowable<String> generate() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
        		 .map(tick -> {
                     int number = (int)Math.floor((Math.random()*(60)+60));
                    return  NameGenerator.generate() +": Heart Rate : "+ number;
           
        		 });
    }
    
    
    @Outgoing("generated-blood-name")           
    public Flowable<String> generateBloodPressure() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> {
                    int number = (int)Math.floor((Math.random()*(60)+120));
                   return  NameGenerator.generate() +": Blood Pressure  : "+  number;
                });
    }
    
    @Outgoing("generated-blood-oxygen-name")           
    public Flowable<String> generateBloodOxygen() {  
        return Flowable.interval(5, TimeUnit.SECONDS)
        		 .map(tick -> {
                     int number = (int)Math.floor((Math.random()*(10)+90));
                    return  NameGenerator.generate() +": Blood oxygen : "+  number;
                 });
    }

}