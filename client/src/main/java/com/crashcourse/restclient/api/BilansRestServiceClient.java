package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.BilansTO;

import java.util.Date;

public interface BilansRestServiceClient {

    BilansTO getLastBilans();

    void addBilans(Date dataBilansowana);
}
