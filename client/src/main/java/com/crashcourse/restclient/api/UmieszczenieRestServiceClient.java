package com.crashcourse.restclient.api;

import com.crashcourse.restclient.datatype.TowarTO;
import com.crashcourse.restclient.datatype.UmieszczenieTO;
import java.util.List;

public interface UmieszczenieRestServiceClient {

    List<UmieszczenieTO> getUmieszczenieTowaru(TowarTO towar);

    void updateUmieszczenie(UmieszczenieTO umieszczenie);
}
