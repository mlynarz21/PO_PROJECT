package com.capgemini.persistence.repository.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.capgemini.common.datatypes.enumerations.Category;
import com.capgemini.persistence.entity.Artifact;
import com.capgemini.persistence.repository.ArtifactRepository;

@Repository
public class ArtifactRepositoryImpl implements ArtifactRepository {

    private static final Map<Long, Artifact> mockedData;
    static {
        mockedData = new HashMap<Long, Artifact>();
        mockedData.put(1L, new Artifact(1L, new GregorianCalendar(2016, 8, 8).getTime(), "Good Artifact", Category.SEMIPRO,
                "This artifact was created for customers with the category semipro."));
        mockedData.put(2L, new Artifact(2L, new GregorianCalendar(2016, 9, 9).getTime(), "Perfect Artifact", Category.PROFESSIONAL,
                "This artifact was designed by a team o high qualified scientists and field tested by the US Army. It's created for real professionals."));
        mockedData.put(3L, new Artifact(3L, new GregorianCalendar(2016, 10, 10).getTime(), "Sufficient Artifact", Category.AMATEUR,
                "It works, so it is perfect for all amateurs."));
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
}
