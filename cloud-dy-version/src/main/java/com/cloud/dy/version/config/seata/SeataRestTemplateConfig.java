package com.cloud.dy.version.config.seata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


@Configuration
public class SeataRestTemplateConfig {

    @Autowired(
            required = false
    )
    private Collection<RestTemplate> restTemplates;

    public SeataRestTemplateConfig(Collection<RestTemplate> restTemplates) {
        this.restTemplates = restTemplates;
    }

    public SeataRestTemplateConfig() {
    }

    public SeataRestTemplateInterceptor seataRestTemplateInterceptor() {
        return new SeataRestTemplateInterceptor();
    }

    @PostConstruct
    public void init() {
        if (this.restTemplates != null && this.restTemplates.size() > 0) {
            Iterator var1 = this.restTemplates.iterator();
            while (var1.hasNext()) {
                RestTemplate restTemplate = (RestTemplate) var1.next();
                List<ClientHttpRequestInterceptor> interceptors = new ArrayList(restTemplate.getInterceptors());
                interceptors.add(this.seataRestTemplateInterceptor());
                restTemplate.setInterceptors(interceptors);
            }
        }
    }
}