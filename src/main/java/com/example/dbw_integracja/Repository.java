package com.example.dbw_integracja;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public class Repository implements CrudRepository<String, Long> {
    @Override
    public <S extends String> S save(S entity) {
        return null;
    }

    @Override
    public <S extends String> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<String> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<String> findAll() {
        return null;
    }

    @Override
    public Iterable<String> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(String entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends String> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

