package com.StoreX.persistence.repository.impl;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BilansRepositoryImpl implements BilansRepository{

    private static final List<Bilans> mockedData;
    static {
        mockedData = new ArrayList<>();
        mockedData.add(new Bilans(1, new GregorianCalendar(2016, 8, 8).getTime(), new GregorianCalendar(2016, 8, 8).getTime()));
    }

    public List<String> getMissingBalanceDates(){
        List<String> toReturn= new ArrayList<>();
        Date lastDate;
        Date currentDate = Calendar.getInstance().getTime();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        if(mockedData==null)
            toReturn.add(df.format(currentDate));
        else {
            lastDate = mockedData.stream().map(u -> u.getDataBilansu()).max(Date::compareTo).get();
            while (lastDate.getYear() != currentDate.getYear() || lastDate.getMonth() < currentDate.getMonth() && lastDate.getYear() == currentDate.getYear()) {
                toReturn.add(df.format(lastDate));
                lastDate.setMonth(lastDate.getMonth() + 1);
            }
        }
        return toReturn;
    }

    public Bilans createBilans(Bilans bilans){
        mockedData.add(bilans);
        return bilans;
    }

    public List<Bilans> findAllBilans(){
        return mockedData;
    }

}
