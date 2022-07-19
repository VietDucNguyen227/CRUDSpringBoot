package com.example.ex5crud.controller;

import com.example.ex5crud.model.TblSubjects;
import com.example.ex5crud.service.TblSubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TblSubjectsController {
    @Autowired
    TblSubjectsService tblSubjectsService;

    @GetMapping("/tblsubjects")
    public ResponseEntity<List<TblSubjects>> listAllSubject(){
        List<TblSubjects> tblSubjectsList = tblSubjectsService.getAllSubjects();
        if (tblSubjectsList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tblSubjectsList,HttpStatus.OK);
    }

    @PostMapping("tblsubjects")
    public ResponseEntity<TblSubjects> saveSubject(@RequestBody TblSubjects tblSubjects){
        tblSubjectsService.saveSubject(tblSubjects);
        return ResponseEntity.ok(tblSubjects);
    }

    @PutMapping("tblsubjects/{id}")
    public ResponseEntity<TblSubjects> updateSubject(@PathVariable("id") Long id,
                                                     @RequestBody TblSubjects tblSubjects){
        TblSubjects oldTblSubjects = tblSubjectsService.getOne(id);
        if (oldTblSubjects == null){
            return ResponseEntity.notFound().build();
        }else {
            oldTblSubjects.setName(tblSubjects.getName());
            oldTblSubjects.setDescription(tblSubjects.getDescription());
            oldTblSubjects.setSem(tblSubjects.getSem());
            oldTblSubjects.setDuration(tblSubjects.getDuration());
            tblSubjectsService.saveSubject(oldTblSubjects);
            return ResponseEntity.ok(oldTblSubjects);
        }
    }

    @DeleteMapping("tblsubjects/{id}")
    public ResponseEntity<TblSubjects> deleteSubject(@PathVariable("id") Long id){
        Optional<TblSubjects> deleteSubject = tblSubjectsService.findSubjectByID(id);
        if (deleteSubject == null) {
            return ResponseEntity.notFound().build();
        }else{
            tblSubjectsService.deleteSubject(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("tblsubjects/{id}")
    public ResponseEntity<TblSubjects> getSubjectById(@PathVariable("id") Long id){
        TblSubjects tblSubjects = tblSubjectsService.getOne(id);
        return new ResponseEntity(tblSubjects,HttpStatus.OK);
    }

    //http://localhost:8080/tblsubjects/findByName?name=toan
    @GetMapping("tblsubjects/findByName")
    public ResponseEntity<List<TblSubjects>> getSubjectByName(@RequestParam String name){
        return new ResponseEntity(tblSubjectsService.getSubjectByName(name),HttpStatus.OK);

    }

    @GetMapping("tblsubjects/findBySem")
    public ResponseEntity<List<TblSubjects>> getSubjectBySem(@RequestParam int sem){
        return new ResponseEntity(tblSubjectsService.getSubjectBySem(sem),HttpStatus.OK);
    }

    @RequestMapping(value = "/tblsubjects/sort", method = RequestMethod.GET)
    public ResponseEntity<List<TblSubjects>> listAllSubjectsSortByName(){
        List<TblSubjects> list = tblSubjectsService.getAllByOrderByNameDesc();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //http://localhost:8080/tblsubjects/countName?name=toan
    @RequestMapping(value = "/tblsubjects/countName", method = RequestMethod.GET)
    public ResponseEntity<TblSubjects> countByName(){
        Long tblSubjects = tblSubjectsService.getCountByName();
        return new ResponseEntity(tblSubjects, HttpStatus.OK);
    }

    //http://localhost:8080/tblsubjects/countSem?sem=2022
    @RequestMapping(value = "/tblsubjects/countSem", method = RequestMethod.GET)
    public ResponseEntity<TblSubjects> countBySem(@RequestParam(value = "sem") int sem){
        Long tblSubjects = tblSubjectsService.countTblSubjectsBySem(sem);
        return new ResponseEntity(tblSubjects, HttpStatus.OK);
    }

//    @RequestMapping(value = "/tblsubjects/countGroupSem", method = RequestMethod.GET)
//    public ResponseEntity<TblSubjects> countSem(){
//        List<TblSubjects> tblSubjects = tblSubjectsService.getCountBySem();
//        return new ResponseEntity(tblSubjects, HttpStatus.OK);
//    }

}
