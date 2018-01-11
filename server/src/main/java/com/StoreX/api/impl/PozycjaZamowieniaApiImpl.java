package com.StoreX.api.impl;

import com.StoreX.api.PozycjaZamowieniaApi;
import com.StoreX.common.datatypes.bo.PozycjaZamowieniaBO;
import com.StoreX.common.datatypes.to.PozycjaZamowieniaTO;
import com.StoreX.service.ZamowienieServices.PozycjaZamowieniaSearchService;
import com.StoreX.service.ZamowienieServices.PozycjaZamowieniaProceedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;


//todo: change to pozycja zamowienia ZAKUPU?
@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class PozycjaZamowieniaApiImpl implements PozycjaZamowieniaApi{

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    PozycjaZamowieniaSearchService pozycjaZamowieniaSearchService;
    @Autowired
    PozycjaZamowieniaProceedService pozycjaZamowieniaProceedService;


    /**
     * Pobiera wszystkie Pozycje Zamówienia dla Zamówienia o podanym Id
     * @param ID IdZamówienia
     * @param sessionId Id sesji
     * @return Lista pozycji zamówień
     */
    @Override
    @RequestMapping(value = "/getPozycjeZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PozycjaZamowieniaTO>> getPozycjeZamowienia(@RequestBody Long ID, @RequestHeader(value = "SessionID") String sessionId){
        List<PozycjaZamowieniaBO> pozycjeZamowieniaBO = null;
        try {
            pozycjeZamowieniaBO = pozycjaZamowieniaSearchService.findAllforZamowienie(sessionId, ID);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        List<PozycjaZamowieniaTO> results = new ArrayList<>();

        for (PozycjaZamowieniaBO pozycja : pozycjeZamowieniaBO) {
            results.add(modelMapper.map(pozycja, PozycjaZamowieniaTO.class));
        }

        return new ResponseEntity<List<PozycjaZamowieniaTO>>(results, HttpStatus.OK);
    }

    /**
     * Pobierea wskazaną ilośc towaru z lokalizacji i dodaje do ilości zrealizowanej w pozycji zamówienia.
     * Metoda wykorzystywana przy kompletowaniu zamówienia.
     * @param transferList Lista parametrów (Id Pozycji Bilansu, Id Umieszczenia, Ilość)
     * @param sessionId Id sesji
     * @return Informację o powodzeniu operacji
     */
    @Override
    @RequestMapping(value = "/proceedPozycjaZamowienia/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> proceedPozycjaZamowienia(@RequestBody List<Double> transferList, @RequestHeader(value = "SessionID") String sessionId) {

        Long idPozycji = transferList.get(0).longValue();
        Long idUmieszcznia = transferList.get(1).longValue();
        double ilosc = transferList.get(2);

        boolean wykonano = false;
        try {
            pozycjaZamowieniaProceedService.ProceedPozycjaZamowienia(sessionId, idPozycji, idUmieszcznia, ilosc);
        } catch (AuthenticationException e) {
            return new ResponseEntity<Boolean>(wykonano, HttpStatus.UNAUTHORIZED);
        }catch (Exception e){
            return new ResponseEntity<Boolean>(wykonano, HttpStatus.NOT_ACCEPTABLE);
        }


        wykonano = true;
        return new ResponseEntity<Boolean>(wykonano, HttpStatus.OK);
    }

}