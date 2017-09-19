package com.crashcourse.restclient.main.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.crashcourse.restclient.api.AuthorizationRestServiceClient;
import com.crashcourse.restclient.api.impl.AuthorizationRestServiceClientImpl;
import com.crashcourse.restclient.controller.basic.DialogManager;
import com.crashcourse.restclient.controller.basic.ScreensConfiguration;

@Configuration
@ComponentScan(basePackages = { "com.crashcourse.restclient.api.impl" })
@Import(ScreensConfiguration.class)
@PropertySource("classpath:/config.properties")
public class LibraryAppConfiguration {

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>> singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }

    @Bean
    AuthorizationRestServiceClient authorization() {
        return new AuthorizationRestServiceClientImpl();
    }

    @Bean
    LibrarySecurityContext getSecurityContext() {
        return new LibrarySecurityContext();
    }

    @Bean
    DialogManager getDialogManager() {
        return new DialogManager();
    }

}
