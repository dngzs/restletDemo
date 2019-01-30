package com.demo.restlet;

import org.restlet.ext.jaxrs.InstantiateException;
import org.restlet.ext.jaxrs.ObjectFactory;

public class V5SpringJaxObjectFactory implements ObjectFactory {
    /** The jax-bean collection that drives this component. **/
    private V5JaxBeanCollection myBeanCollection;

    /**
     * Create the Spring Jax Object Factory.
     * @param beanCollection The jax-bean collection that will drive this component.
     */
    public V5SpringJaxObjectFactory(final V5JaxBeanCollection beanCollection) {
        this.myBeanCollection = beanCollection;
    }

    @Override
    public <T> T getInstance(final Class<T> jaxRsClass) throws InstantiateException {
        T bean = myBeanCollection.getBean(jaxRsClass);
        return bean;
    }
}

