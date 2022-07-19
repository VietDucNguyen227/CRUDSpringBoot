package com.example.ex5crud.service;

import com.example.ex5crud.model.TblSubjects;

import java.util.List;
import java.util.Optional;

public interface TblSubjectsService {
    List<TblSubjects> getAllSubjects();

    void saveSubject(TblSubjects tblSubjects);

    void deleteSubject(long id);

    Optional<TblSubjects> findSubjectByID(long id);

    TblSubjects getOne(long id);

    List<TblSubjects> getSubjectByName(String name);

    List<TblSubjects> getSubjectBySem(int sem);

    List<TblSubjects> getAllByOrderByNameDesc();

    Long getCountByName();

    Long countTblSubjectsBySem(int sem);

//    List<TblSubjects> getCountBySem();

}
