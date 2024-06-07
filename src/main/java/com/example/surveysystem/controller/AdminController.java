package com.example.surveysystem.controller;

import com.example.surveysystem.dal.DataAccessLayer;
import com.example.surveysystem.models.Man;
import com.example.surveysystem.models.Survey;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3333")
@RequestMapping("/authorized")
public class AdminController {
    private final DataAccessLayer dataAccessLayer;


    @Autowired
    public AdminController(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }


    @PostMapping("create/survey/")
    public ResponseEntity<String> createSurvey(@RequestBody Survey survey) {
        dataAccessLayer.createSurvey(survey);
        return ResponseEntity.ok("Create!");
    }

    @DeleteMapping("delete/survey/{id}")
    public ResponseEntity deleteSurveyById(@PathVariable("id") long id) {
        dataAccessLayer.deleteSurvey(id);
        return ResponseEntity.ok("Delete!");
    }

    @PostMapping("update/survey/{id}")
    public ResponseEntity updateSurveylById(@PathVariable("id")
                                            long id, @RequestBody Survey newSurvey) {
        dataAccessLayer.updateSurvey(id, newSurvey);
        return ResponseEntity.ok("Update!");
    }



    @PostMapping("create/man/")
    public ResponseEntity<String> createMan(@RequestBody Man man) {
        dataAccessLayer.createMan(man);
        return ResponseEntity.ok("Create!");
    }

    @DeleteMapping("delete/man/{id}")
    public ResponseEntity deleteManById(@PathVariable("id") long id) {
        dataAccessLayer.deleteMan(id);
        return ResponseEntity.ok("Delete!");
    }

    @PostMapping("update/man/{id}")
    public ResponseEntity updateManlById(@PathVariable("id")
                                         long id, @RequestBody Man newMan) {
        dataAccessLayer.updateMan(id, newMan);
        return ResponseEntity.ok("Update!");
    }

}
