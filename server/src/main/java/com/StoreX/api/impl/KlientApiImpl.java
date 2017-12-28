package com.StoreX.api.impl;

import com.StoreX.api.KlientApi;
import com.StoreX.common.datatypes.bo.KlientBO;
import com.StoreX.common.datatypes.to.KlientTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//todo: delete
@CrossOrigin
@RestController
@RequestMapping("/rest/artifactlibrary/component/v1")
public class KlientApiImpl implements KlientApi{

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @RequestMapping(value = "/getKlient/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KlientTO> getKlient(@RequestBody KlientTO klient, @RequestHeader(value = "SessionID") String sessionId){
        KlientBO klientBO = null;
//        try {
//            klientBO = searchService.findAllArtifacts(sessionId);
//        } catch (AuthenticationException e) {
//            return new ResponseEntity<KlientTO>(HttpStatus.UNAUTHORIZED);
//        }

        KlientTO result = modelMapper.map(klientBO, KlientTO.class);

        return new ResponseEntity<KlientTO>(result, HttpStatus.OK);
    }

}
