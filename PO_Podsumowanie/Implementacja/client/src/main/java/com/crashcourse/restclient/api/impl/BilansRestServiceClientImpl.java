package com.crashcourse.restclient.api.impl;

import com.crashcourse.restclient.api.BilansRestServiceClient;
import com.crashcourse.restclient.datatype.BilansTO;
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
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

/**
 * REST client odpiwiadający za bilans REST service (implementacja).
 */
@Component
public class BilansRestServiceClientImpl implements BilansRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StoreXSecurityContext app;

    /**
     * metoda pobierająca Bilans za ostatni bilansowany miesiąc znajdujący się w bazie danych
     * @return BilansTO - obiekt transferowy Bilansu zawierający dane o ostatnim bilansie
     */
    @Override
    public BilansTO getLastBilans(){
        RequestEntity<BilansTO> requestEntity = buildRequest(builGetLastBilansRequestUri(), null, HttpMethod.GET);

        ResponseEntity<BilansTO> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<BilansTO>() {
        });
        return exchange.getBody();
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla pobierania ostatniego bilansu
     */
    private URI builGetLastBilansRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/getLastBilans/").toString());
    }

    /**
     * metoda dodająca nowy bilans za wskazany w parametrze miesiąc do bazy danych
     * @param dataBilansowana data miesiąca bilansowanego
     */
    @Override
    public void addBilans(Date dataBilansowana){
        RequestEntity<Date> request = buildRequest(builAddBilansRequestUri(), dataBilansowana, HttpMethod.POST);

        restTemplate.exchange(request, new ParameterizedTypeReference<Boolean>() {
        });
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla dodawania bilansu
     */
    private URI builAddBilansRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/addBilans/").toString());
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
