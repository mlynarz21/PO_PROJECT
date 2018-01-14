package com.crashcourse.restclient.api.impl;

import com.crashcourse.restclient.datatype.PozycjaZamowieniaTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    private <T extends Object> RequestEntity<T> buildRequest(URI uri, T body, HttpMethod method) {

        return new RequestEntity<>(body, null, method, uri);
    }
}
