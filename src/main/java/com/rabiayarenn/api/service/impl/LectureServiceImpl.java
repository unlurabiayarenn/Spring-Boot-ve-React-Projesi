package com.rabiayarenn.api.service.impl;

import com.rabiayarenn.api.common.GeneralException;
import com.rabiayarenn.api.entity.Lecture;
import com.rabiayarenn.api.repository.ILectureRepository;
import com.rabiayarenn.api.service.ILectureService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements ILectureService {

    private final ILectureRepository lectureRepository;

    public LectureServiceImpl(ILectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture save(Lecture lecture) {
        if (StringUtils.isEmpty(lecture.getName())) {
            throw new GeneralException("Lecture name cannot be empty");
        }
        if (lecture.getTeacher()==null) {
            throw new GeneralException("Teacher cannot be empty");
        }
        return lectureRepository.save(lecture);
        //return null;
    }

    @Override
    public Lecture getById(Integer id) {
        //return null;
        return lectureRepository.findById(id).orElseThrow(() -> new GeneralException("Lecture not found"));
    }

    @Override
    public List<Lecture> getAll() {
        //return List.of();
        return lectureRepository.findAll();
    }

    @Override
    public Page<Lecture> getAll(Pageable pageable) {
        //return null;
        return lectureRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        if (!lectureRepository.existsById(id)) {
            throw new GeneralException("Lecture not found");
        }
        lectureRepository.deleteById(id);
    }
}
