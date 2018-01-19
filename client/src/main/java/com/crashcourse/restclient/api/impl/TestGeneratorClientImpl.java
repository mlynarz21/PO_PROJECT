package com.crashcourse.restclient.api.impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class TestGeneratorClientImpl {

    private String serviceUrl = "http://localhost:8888/rest/artifactlibrary/component/v1";

    public void addTest() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildAddTestRequestUri(), null, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildAddTestRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/addTest/").toString());
    }

    public void turncate(String param) {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildTurncateRequestUri(), param, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildTurncateRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/turncate/").toString());
    }

    private URI buildTurncateAllRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/turncateAll/").toString());
    }

    public void turncateAll() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildTurncateAllRequestUri(), null ,HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    public void add002() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildAdd002RequestUri(), null, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildAdd002RequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/add002/").toString());
    }

    public void add003_9() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildAdd003_9RequestUri(), null, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildAdd003_9RequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/add003_9/").toString());
    }
    public void add004_5_6_7_8_10() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildAdd004_5_6_7_8_10RequestUri(), null, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildAdd004_5_6_7_8_10RequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/add004_5_6_7_8_10/").toString());
    }

    public void add011() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<String> requestEntity = buildRequest(buildAdd011RequestUri(), null, HttpMethod.POST);

        ResponseEntity<Boolean> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI buildAdd011RequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/add011/").toString());
    }


    private <T extends Object> RequestEntity<T> buildRequest(URI uri, T body, HttpMethod method) {

        return new RequestEntity<>(body, null, method, uri);
    }
}
