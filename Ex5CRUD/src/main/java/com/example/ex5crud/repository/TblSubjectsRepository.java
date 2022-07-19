package com.example.ex5crud.repository;

import com.example.ex5crud.model.TblSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface TblSubjectsRepository extends JpaRepository<TblSubjects, Long> {
    List<TblSubjects> findByName(String name);
    List<TblSubjects> findBySem(int sem);
    List<TblSubjects> findAllByOrderByNameDesc();

    @Query("SELECT COUNT(s.name) FROM TblSubjects s")
    long getCountByName();

    Long countTblSubjectsBySem(int sem);

//    @Query("select count(s.name) as subject,s.sem From TblSubjects s group by s.sem")
//    List<TblSubjects> getCountBySem();
}
