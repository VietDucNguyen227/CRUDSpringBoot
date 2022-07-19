package com.example.ex5crud.service;

import com.example.ex5crud.model.TblSubjects;
import com.example.ex5crud.repository.TblSubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblSubjectsServiceImp implements TblSubjectsService{
    @Autowired
    private TblSubjectsRepository tblSubjectsRepository;


    @Override
    public List<TblSubjects> getAllSubjects() {
        return tblSubjectsRepository.findAll();
    }

    @Override
    public void saveSubject(TblSubjects tblSubjects) {
        tblSubjectsRepository.save(tblSubjects);
    }

    @Override
    public void deleteSubject(long id) {
        tblSubjectsRepository.deleteById(id);
    }

    @Override
    public Optional<TblSubjects> findSubjectByID(long id) {
        return tblSubjectsRepository.findById(id);
    }

    @Override
    public TblSubjects getOne(long id) {
        return tblSubjectsRepository.findById(id).get();
    }

    @Override
    public List<TblSubjects> getSubjectByName(String name) {
        return tblSubjectsRepository.findByName(name);
    }

    @Override
    public List<TblSubjects> getSubjectBySem(int sem) {
        return tblSubjectsRepository.findBySem(sem);
    }

    @Override
    public List<TblSubjects> getAllByOrderByNameDesc() {
        return tblSubjectsRepository.findAllByOrderByNameDesc();
    }

    @Override
    public Long getCountByName() {
        return tblSubjectsRepository.getCountByName();
    }

    @Override
    public Long countTblSubjectsBySem(int sem) {
        return tblSubjectsRepository.countTblSubjectsBySem(sem);
    }

//    @Override
//    public List<TblSubjects> getCountBySem() {
//        return tblSubjectsRepository.getCountBySem();
//    }

}
