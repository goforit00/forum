package com.goforit.firstapple.forum.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.goforit.firstapple.forum.model.UserToken;


@Path("/usertoken")
public class UserTokenRestfulService {
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public UserToken get(@QueryParam("id") String id){
        UserToken token=new UserToken();
        token.setId(Long.valueOf(id));
        token.setToken("helloworld");
        return token;
    }

}
