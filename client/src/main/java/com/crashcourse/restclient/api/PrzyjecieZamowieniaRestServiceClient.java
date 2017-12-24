package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

public interface PrzyjecieZamowieniaRestServiceClient {

    BilansTO getLastBilans();

    void addBilans(BilansTO bilans);
}
