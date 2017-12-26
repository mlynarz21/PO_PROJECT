package com.StoreX.persistence.repository.impl;
import com.StoreX.persistence.entity.Bilans;
import com.StoreX.persistence.repository.BilansRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.AbstractSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository("bilansDAO")
public class BilansRepositoryImpl {//implements BilansRepository{
//    @Bean
//    public AbstractSessionFactoryBean sessionFactoryBean(){
//        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
//        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
//        return sessionFactoryBean;
//    }
//
//    public SessionFactory sessionFactory() {
//        return sessionFactoryBean().getObject();
//    }



//    public List<Bilans> findAllBilans(){
//        return (List<Bilans>)sessionFactory().getCurrentSession().createCriteria(Bilans.class).list();
//    }
//    public void addBilans(Bilans employee) {
//        sessionFactory().getCurrentSession().saveOrUpdate(employee);
//    }
//    private static final List<Bilans> mockedData;
//    static {
//        mockedData = new ArrayList<>();
//        mockedData.add(new Bilans(1, new GregorianCalendar(2016, 8, 8).getTime(), new GregorianCalendar(2016, 8, 8).getTime()));
//    }
//
//    public List<String> getMissingBalanceDates(){
//        List<String> toReturn= new ArrayList<>();
//        Date lastDate;
//        Date currentDate = Calendar.getInstance().getTime();
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//
//        if(mockedData==null)
//            toReturn.add(df.format(currentDate));
//        else {
//            lastDate = mockedData.stream().map(u -> u.getDataBilansu()).max(Date::compareTo).get();
//            while (lastDate.getYear() != currentDate.getYear() || lastDate.getMonth() < currentDate.getMonth() && lastDate.getYear() == currentDate.getYear()) {
//                toReturn.add(df.format(lastDate));
//                lastDate.setMonth(lastDate.getMonth() + 1);
//            }
//        }
//        return toReturn;
//    }
//
//    public Bilans createBilans(Bilans bilans){
//        mockedData.add(bilans);
//        return bilans;
//    }



}
