package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

public interface PozycjaPrzyjeciaRestServiceClient {

    BilansTO getLastBilans();

    void addBilans(BilansTO bilans);
}
