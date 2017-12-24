package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

public interface WydanieRestServiceClient {

    BilansTO getLastBilans();

    void addBilans(BilansTO bilans);
}
