package com.rabiayarenn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rabiayarenn.api.entity.Lecture;
import org.springframework.stereotype.Repository;

@Repository
public interface ILectureRepository extends JpaRepository<Lecture, Integer> {
}
