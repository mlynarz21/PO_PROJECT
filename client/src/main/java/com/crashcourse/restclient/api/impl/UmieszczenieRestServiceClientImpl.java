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

/**
 * REST client odpiwiadający za umieszczenie REST service (implementacja).
 */
@Component
public class UmieszczenieRestServiceClientImpl implements UmieszczenieRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StoreXSecurityContext app;


    /**
     * metoda pobierająca liste umieszczeń towaru o podanym ID
     * @param IDTowaru id towaru, którego mają dotyczyć umieszczenia
     * @return lista umieszczeń towaru o podanym ID
     */
    @Override
    public List<UmieszczenieTO> getUmieszczenieTowaru(Long IDTowaru) {
        RequestEntity<Long> requestEntity = buildRequest(buildGetUmieszczenieTowaruRequestUri(), IDTowaru, HttpMethod.POST);

        ResponseEntity<List<UmieszczenieTO>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<UmieszczenieTO>>() {
        });
        return exchange.getBody();
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla pobierania umieszczeń towaru
     */
    private URI buildGetUmieszczenieTowaruRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/getUmieszczenieTowaru/").toString());
    }

    /**
     * metoda odpowiadająca za budowę zapytania restowego do servera
     * @param uri URI zapytania
     * @param body ciało zapytania
     * @param method Http metoda
     * @param <T> wysyłany typ żądania
     * @return metoda zwraca RequestEntity o typie żądanym
     */
    private <T extends Object> RequestEntity<T> buildRequest(URI uri, T body, HttpMethod method) {
        HttpHeaders head = buildRequestHeader();

        return new RequestEntity<>(body, head, method, uri);
    }

    /**
     * metoda do budowania nagłówka używanego do autoryzacji działania po stronie servera
     * @return nagłówek JSON'a zawierający UUID
     */
    private HttpHeaders buildRequestHeader() {
        HttpHeaders head = new HttpHeaders();
        head.add("SessionID", Optional.ofNullable(app.getSession())
                .map(SessionTo::getSessionId)
                .map(UUID::toString)
                .orElse(null));
        return head;
    }
}
