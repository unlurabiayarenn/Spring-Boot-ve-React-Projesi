package com.rabiayarenn.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IService <T>{//generic bir servis yapısı oluşacak
    T save(T t);
    T getById(Integer id);
    List<T> getAll();
    Page<T> findAll(Pageable pageable);
    void delete(T t);

}
