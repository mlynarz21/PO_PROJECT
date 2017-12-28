package com.crashcourse.restclient.api.impl;

import com.crashcourse.restclient.api.UmieszczenieRestServiceClient;
import com.crashcourse.restclient.datatype.*;
import com.crashcourse.restclient.main.config.StoreXSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UmieszczenieRestServiceClientImpl implements UmieszczenieRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StoreXSecurityContext app;


    @Override
    public List<UmieszczenieTO> getUmieszczenieTowaru(Long IDTowaru) {
        RequestEntity<Long> requestEntity = buildRequest(buildGetUmieszczenieTowaruRequestUri(), IDTowaru, HttpMethod.POST);

        ResponseEntity<List<UmieszczenieTO>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<UmieszczenieTO>>() {
        });
        return exchange.getBody();
    }

    private URI buildGetUmieszczenieTowaruRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/getUmieszczenieTowaru/").toString());
    }

    @Override
    public void updateUmieszczenie(UmieszczenieTO umieszczenie) {
        RequestEntity<UmieszczenieTO> request = buildRequest(builUpdateUmieszczenieRequestUri(), umieszczenie, HttpMethod.POST);

        restTemplate.exchange(request, new ParameterizedTypeReference<Boolean>() {
        });
    }

    private URI builUpdateUmieszczenieRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/updateUmieszczenie/").toString());
    }


    private <T extends Object> RequestEntity<T> buildRequest(URI uri, T body, HttpMethod method) {
        HttpHeaders head = buildRequestHeader();

        return new RequestEntity<>(body, head, method, uri);
    }

    private HttpHeaders buildRequestHeader() {
        HttpHeaders head = new HttpHeaders();
        head.add("SessionID", Optional.ofNullable(app.getSession())
                .map(SessionTo::getSessionId)
                .map(UUID::toString)
                .orElse(null));
        return head;
    }
}
