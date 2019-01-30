package com.demo.restlet;


import org.restlet.ext.jaxrs.JaxRsApplication;
import org.restlet.ext.spring.SpringComponent;

import javax.ws.rs.core.Application;


public class MyJaxRsApplication extends JaxRsApplication {

    public MyJaxRsApplication(SpringComponent springComponent,Application application) {
        super(springComponent.getContext());
        this.add(application);
    }
}
