package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

public interface TowarRestServiceClient {

    BilansTO getLastBilans();

    void addBilans(BilansTO bilans);
}
