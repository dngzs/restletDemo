package com.demo.restlet;

import java.util.Set;

public class V5SpringJaxApplication extends javax.ws.rs.core.Application {


    /** The jax-bean collection that drives this component. **/
    private V5JaxBeanCollection myBeanCollection;

    /**
     * Create the Spring Jax Config.
     * @param beanCollection The jax-bean collection that will drive this component.
     */
    public V5SpringJaxApplication(final V5JaxBeanCollection beanCollection) {
        this.myBeanCollection = beanCollection;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return myBeanCollection.getBeanTypes();
    }
}
