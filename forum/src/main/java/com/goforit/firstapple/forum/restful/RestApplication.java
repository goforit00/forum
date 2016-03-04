package com.goforit.firstapple.forum.restful;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestApplication extends ResourceConfig{
    public RestApplication() {
        
        packages("com.goforit.firstapple.forum.restful");

        register(JacksonJsonProvider.class);
       
          }
}
