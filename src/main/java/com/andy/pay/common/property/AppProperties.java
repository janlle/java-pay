package com.andy.pay.common.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Leone
 * @since 2018-07-31
 **/
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private AliProperties ali = new AliProperties();

    private WxProperties wx = new WxProperties();

    public AliProperties getAli() {
        return ali;
    }

    public void setAli(AliProperties ali) {
        this.ali = ali;
    }

    public WxProperties getWx() {
        return wx;
    }

    public void setWx(WxProperties wx) {
        this.wx = wx;
    }
}
