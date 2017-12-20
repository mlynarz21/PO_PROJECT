package com.StoreX.persistence.repository.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.StoreX.common.datatypes.bo.ArtifactBo;
import org.springframework.stereotype.Repository;

import com.StoreX.common.datatypes.enumerations.Category;
import com.StoreX.common.datatypes.enumerations.Status;
import com.StoreX.persistence.entity.Artifact;
import com.StoreX.persistence.repository.ArtifactRepository;

@Repository
public class ArtifactRepositoryImpl implements ArtifactRepository {

    private static final Map<Long, Artifact> mockedData;
    static {
        mockedData = new HashMap<Long, Artifact>();
        mockedData.put(1L, new Artifact(1L, new GregorianCalendar(2016, 8, 8).getTime(), "Good Artifact", Category.COMEDY,
                "This artifact was created for customers with the category semipro.", Status.AVALIBLE, ""));
        mockedData.put(2L, new Artifact(2L, new GregorianCalendar(2016, 9, 9).getTime(), "Perfect Artifact", Category.DRAMA,
                "This artifact was designed by a team o high qualified scientists and field tested by the US Army. It's created for real professionals.", Status.BOOKED, "kowalski"));
        mockedData.put(3L, new Artifact(3L, new GregorianCalendar(2016, 10, 10).getTime(), "Sufficient Artifact", Category.KRIMI,
                "It works, so it is perfect for all amateurs.", Status.BORROWED, "user"));
    }

    @Override
    public Artifact findArtifactById(long id) {
        return mockedData.get(id);
    }

    @Override
    public List<Artifact> findAllArtifacts() {
        return new ArrayList<Artifact>(mockedData.values());
    }

    @Override
    public List<Artifact> findArtifactsByType(Category type) {
        return mockedData.values().stream().filter(a -> a.getType() == type).collect(Collectors.toList());
    }

    @Override
    public List<Artifact> findSpecifiedArtifacts(ArtifactBo artifactBo) {
      
    	List <Artifact> lists = findAllArtifacts();
    	if(artifactBo.getName()!=null && !artifactBo.getName().equals("") ){
    		lists = lists.stream().filter(a -> a.getName().equals(artifactBo.getName())).collect(Collectors.toList());
    	}
    	if(artifactBo.getStatus()!=null){
    		lists = lists.stream().filter(a -> a.getStatus().equals(artifactBo.getStatus())).collect(Collectors.toList());
    	}

    	if(artifactBo.getType()!=null){
    		lists = lists.stream().filter(a -> a.getType().equals(artifactBo.getType())).collect(Collectors.toList());
    	}

    	if( artifactBo.getUsername()!=null && artifactBo.getUsername()!="" ){
    		lists = lists.stream().filter(a -> a.getUsername().equals(artifactBo.getUsername())).collect(Collectors.toList());
    	}

    	return lists;
    /*	if(!artifactBo.getName().equals("")){
            if(artifactBo.getStatus()!=null){
                if(artifactBo.getType()!=null){
                    return mockedData.values().stream().filter(a -> a.getStatus() == artifactBo.getStatus() && a.getType() == artifactBo.getType() && a.getName().contains(artifactBo.getName())).collect(Collectors.toList());
                }
                else return mockedData.values().stream().filter(a -> a.getStatus() == artifactBo.getStatus() && a.getName().contains(artifactBo.getName())).collect(Collectors.toList());
            } else if (artifactBo.getType()!=null){
                return mockedData.values().stream().filter(a -> a.getType() == artifactBo.getType() && a.getName().contains(artifactBo.getName())).collect(Collectors.toList());
            } else return mockedData.values().stream().filter(a -> a.getName().contains(artifactBo.getName())).collect(Collectors.toList());
        } else if(artifactBo.getStatus()!=null){
            if(artifactBo.getType()!=null) {
                return mockedData.values().stream().filter(a -> a.getType() == artifactBo.getType() && a.getStatus() == artifactBo.getStatus()).collect(Collectors.toList());
            } else return mockedData.values().stream().filter(a -> a.getStatus() == artifactBo.getStatus()).collect(Collectors.toList());
        } else if(artifactBo.getType()!=null) {
            return mockedData.values().stream().filter(a -> a.getType() == artifactBo.getType()).collect(Collectors.toList());
        }
        

        return findAllArtifacts();*/
    }

    @Override
    public Artifact updateArtifact(Artifact artifact) {
        if (mockedData.containsKey(artifact.getId())) {
            mockedData.replace(artifact.getId(), artifact);
        } else {
            mockedData.put(artifact.getId(), artifact);
        }
        return artifact;
    }

    @Override
    public Artifact createArtifact(Artifact artifact) {
        Long lastIndex = getNewIndex();
        artifact.setId(++lastIndex);
        mockedData.put(artifact.getId(), artifact);

        return artifact;
    }

    private Long getNewIndex() {
        return mockedData.keySet().stream().sorted(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        }).findFirst().get();
    }

    @Override
    public boolean deleteArtifactById(long id) {
        Iterator<Entry<Long, Artifact>> iterator = mockedData.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, Artifact> next = iterator.next();
            if (next.getValue().getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean bookArtifactById(Artifact artifact) {
        Iterator<Entry<Long, Artifact>> iterator = mockedData.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, Artifact> next = iterator.next();
            if (next.getValue().getId().equals(artifact.getId())) {
                if(next.getValue().getStatus()==Status.AVALIBLE) {
                    next.getValue().setStatus(Status.BOOKED);
                    next.getValue().setUsername(artifact.getUsername());
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    @Override
    public boolean borrowArtifactById(Artifact artifact) {
        Iterator<Entry<Long, Artifact>> iterator = mockedData.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, Artifact> next = iterator.next();
            if (next.getValue().getId().equals(artifact.getId())) {
                if(next.getValue().getStatus()==Status.BOOKED) {
                    next.getValue().setStatus(Status.BORROWED);
                    return true;
                }
                else return false;
            }
        }
        return false;
    }

    @Override
    public boolean freeArtifactById(Artifact artifact) {
        Iterator<Entry<Long, Artifact>> iterator = mockedData.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, Artifact> next = iterator.next();
            if (next.getValue().getId().equals(artifact.getId())) {
                if(next.getValue().getStatus()==Status.BORROWED) {
                    next.getValue().setStatus(Status.AVALIBLE);
                    next.getValue().setUsername("");
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
}
