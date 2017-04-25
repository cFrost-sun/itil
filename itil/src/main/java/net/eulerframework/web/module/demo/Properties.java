package net.eulerframework.web.module.demo;

import net.eulerframework.common.util.property.PropertyNotFoundException;
import net.eulerframework.common.util.property.PropertyReader;

/**
 * 用户获取系统参数
 * @author cFrost
 *
 */
public final class Properties {

    private final static PropertyReader properties = new PropertyReader("/config.properties");
    
    public static String sdpurl() {
        try {
            return properties.get("sdpurl");
        } catch (PropertyNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
