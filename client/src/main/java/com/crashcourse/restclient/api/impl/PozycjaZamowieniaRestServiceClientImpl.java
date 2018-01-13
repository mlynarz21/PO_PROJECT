package com.crashcourse.restclient.api.impl;

import com.crashcourse.restclient.api.PozycjaZamowieniaRestServiceClient;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * REST client odpiwiadający za pozycję zamówienia REST service (implementacja).
 */
@Component
public class PozycjaZamowieniaRestServiceClientImpl implements PozycjaZamowieniaRestServiceClient {

    @Value("${application.service.url}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StoreXSecurityContext app;


    /**
     * metoda pobierająca wszystie pozycje zamowienia o podanym ID
     * @param ID id zamówienia ktrórego dotyczą pozycje
     * @return lista zawierająca pozycje danego zamówienia
     */
    @Override
    public List<PozycjaZamowieniaTO> getPozycjeZamowienia(Long ID) {
        RequestEntity<Long> requestEntity = buildRequest(buildGetPozycjeZamowieniaRequestUri(), ID, HttpMethod.POST);

        ResponseEntity<List<PozycjaZamowieniaTO>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<PozycjaZamowieniaTO>>() {
        });
        return exchange.getBody();
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla pobierania pozycji zamówienia o podanym ID
     */
    private URI buildGetPozycjeZamowieniaRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/getPozycjeZamowienia/").toString());
    }

    /**
     * metoda odpowiadająca za zmianę ilościową stanu pozycji i umieszczenia w bazie
     * @param idPozycji id pozycji inkrementowanej
     * @param idUmieszcznia id umieszczenia dekrementowanej
     * @param ilosc ilośc która jest procesowana
     */
    @Override
    public void proceedPozycjaZamowienia(Long idPozycji, Long idUmieszcznia, double ilosc){
        List<Double> transferList= new ArrayList<>();
        transferList.add(idPozycji.doubleValue());
        transferList.add(idUmieszcznia.doubleValue());
        transferList.add(ilosc);
        RequestEntity<List<Double>> request = buildRequest(buildProceedPozycjaZamowieniaRequestUri(), transferList, HttpMethod.POST);

        restTemplate.exchange(request, new ParameterizedTypeReference<Boolean>() {
        });
    }

    /**
     * metoda budująca URI dla servera
     * @return URI dla procesowania zmian ilościowych pozycji i umieszczenia
     */
    private URI buildProceedPozycjaZamowieniaRequestUri() {
        return URI.create(new StringBuilder().append(serviceUrl).append("/proceedPozycjaZamowienia/").toString());
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
