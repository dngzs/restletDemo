package com.demo.restlet;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;

@Component
@Path("/v1")
public class Test1Resource  implements MyResource {

    private static final Logger logger = LoggerFactory.getLogger(Test1Resource.class);

    @POST
    @Path("test1")
    public String test1(@FormParam("seq") String json) throws Exception{
        logger.info(json);
        Data data = JSONObject.parseObject(json, Data.class);
        if("error".equals(data.getName())){
            logger.error("error--");
            return "error";
        }

        return "success";
    }



}
