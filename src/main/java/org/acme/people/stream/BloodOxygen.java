package org.acme.people.stream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;


@Path("/bloodoxygen")
public class BloodOxygen {

	// getting values from in memory stream
    @Inject
    @Channel("blood-oxygen-stream") Publisher<String> bloodoxygen; 

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain") 
    public Publisher<String> stream() { 
        return bloodoxygen;
    }

    
}