package com.goforit.firstapple.forum.restful;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.goforit.firstapple.forum.model.User;


@Path("/user")
public class UserRestfulService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("name")
    public Response getUserName(){
        User user=new User();
        user.setId(1);
        user.setEmail("alipay@163.com");
        user.setName("xxx");
        return Response.status(Status.OK).entity(user).build();
        
    }

}
