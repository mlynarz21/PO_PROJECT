package com.crashcourse.restclient.api.impl;

import com.crashcourse.restclient.api.KlientRestServiceClient;
import com.crashcourse.restclient.datatype.KlientTO;
import com.crashcourse.restclient.datatype.SessionTo;
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
import java.util.Optional;
import java.util.UUID;

@Component
public class KlientRestServiceClientImpl implements KlientRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StoreXSecurityContext app;


    @Override
    public KlientTO getKlient(KlientTO klient) {
        RequestEntity<KlientTO> requestEntity = buildRequest(builGetKlientRequestUri(), klient, HttpMethod.POST);

        ResponseEntity<KlientTO> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<KlientTO>() {
        });
        return exchange.getBody();

    }

    private URI builGetKlientRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/getKlient/").toString());
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
