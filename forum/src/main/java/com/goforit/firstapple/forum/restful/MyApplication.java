package com.goforit.firstapple.forum.restful;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by junqingfjq on 15/10/27.
 */

@ApplicationPath("app")
public class MyApplication extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(UserRestfulService.class);
        return s;
    }
}

