/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.impl.cloud;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ExtendedPropertyConfigurerGetter;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.spi.ConfigurerStrategy;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.impl.cloud.CombinedServiceFilterFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class CombinedServiceFilterFactoryConfigurer extends org.apache.camel.support.component.PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        org.apache.camel.impl.cloud.CombinedServiceFilterFactory target = (org.apache.camel.impl.cloud.CombinedServiceFilterFactory) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "servicefilterlist":
        case "serviceFilterList": target.setServiceFilterList(property(camelContext, java.util.List.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "servicefilterlist":
        case "serviceFilterList": return java.util.List.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        org.apache.camel.impl.cloud.CombinedServiceFilterFactory target = (org.apache.camel.impl.cloud.CombinedServiceFilterFactory) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "servicefilterlist":
        case "serviceFilterList": return target.getServiceFilterList();
        default: return null;
        }
    }

    @Override
    public Object getCollectionValueType(Object target, String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "servicefilterlist":
        case "serviceFilterList": return org.apache.camel.cloud.ServiceFilter.class;
        default: return null;
        }
    }
}

