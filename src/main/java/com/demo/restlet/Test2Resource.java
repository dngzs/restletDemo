package com.demo.restlet;

import com.alibaba.fastjson.JSONObject;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.Encoded;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Random;

@Component
@Path("/v2")
public class Test2Resource implements MyResource{
    private static final Logger logger = LoggerFactory.getLogger(Test2Resource.class);

    @POST
    @Path("test2")
    public String test1(@FormParam("seq") String json) throws Exception{
        logger.info(json);
        Data data = JSONObject.parseObject(json, Data.class);
        return "success";
    }
}
