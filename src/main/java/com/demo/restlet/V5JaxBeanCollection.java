package com.demo.restlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;

import java.util.HashSet;
import java.util.Set;

public class V5JaxBeanCollection implements BeanFactoryAware, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(V5JaxBeanCollection.class);


    public <T> T getBean(Class<T> clazz){
        return this.beanFactory.getBean(clazz);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        /**we get the resources extended from V5Resource,and then add the class to the beanTypes set**/
        String[] resourceClassNameList=beanFactory.getBeanNamesForType(V5_BASE_RESOURCE_CLASS);
        if(resourceClassNameList!=null && resourceClassNameList.length>0){
            for(String className:resourceClassNameList){
                beanTypes.add(beanFactory.getType(className));
            }
        }
    }


    private static final Class<?> V5_BASE_RESOURCE_CLASS=MyResource.class;

    private Set<Class<?>> beanTypes = new HashSet<Class<?>>();

    private Set<String> beanNames = new HashSet<String>();

    private ListableBeanFactory beanFactory;


    public Set<Class<?>> getBeanTypes() {
        return beanTypes;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }
}

