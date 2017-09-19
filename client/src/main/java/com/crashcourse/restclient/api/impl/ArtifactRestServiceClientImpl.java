package com.crashcourse.restclient.api.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crashcourse.restclient.api.ArtifactRestServiceClient;
import com.crashcourse.restclient.datatype.ArtifactTo;
import com.crashcourse.restclient.datatype.SessionTo;
import com.crashcourse.restclient.main.config.LibrarySecurityContext;

@Component
public class ArtifactRestServiceClientImpl implements ArtifactRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LibrarySecurityContext app;

    @Override
    public List<ArtifactTo> getAllArtifacts() {

        RequestEntity<Void> requestEntity = this.<Void> builArtifactsRequest(builAllArtifactsRequestUri(), null, HttpMethod.GET);

        ResponseEntity<List<ArtifactTo>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<ArtifactTo>>() {
        });
        return exchange.getBody();
    }

    private <T extends Object> RequestEntity<T> builArtifactsRequest(URI uri, T body, HttpMethod method) {
        HttpHeaders head = buildRequestHeader();

        return new RequestEntity<>(body, head, method, uri);
    }

    private URI builAllArtifactsRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/artifacts/").toString());
    }

    private HttpHeaders buildRequestHeader() {
        HttpHeaders head = new HttpHeaders();
        head.add("SessionID", Optional.ofNullable(app.getSession())
                .map(SessionTo::getSessionId)
                .map(UUID::toString)
                .orElse(null));
        return head;
    }

    private URI builAddArtifactRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/add-artifact/").toString());
    }

    @Override
    public void addArtifact(ArtifactTo artifact) {
        RequestEntity<ArtifactTo> request = builArtifactsRequest(builAddArtifactRequestUri(), artifact, HttpMethod.POST);

        restTemplate.exchange(request, new ParameterizedTypeReference<ArtifactTo>() {
        });
    }

}
