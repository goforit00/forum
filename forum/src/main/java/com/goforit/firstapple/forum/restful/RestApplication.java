package com.goforit.firstapple.forum.restful;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestApplication extends ResourceConfig{
    public RestApplication() {
        
        //���������ڵİ�·��
        packages("com.goforit.firstapple.forum.restful");
        //ע��JSONת����
        register(JacksonJsonProvider.class);
       
          }
}
