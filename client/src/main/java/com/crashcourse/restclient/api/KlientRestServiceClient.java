package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.KlientTO;

public interface KlientRestServiceClient {

    KlientTO getClient(int ID);

}
