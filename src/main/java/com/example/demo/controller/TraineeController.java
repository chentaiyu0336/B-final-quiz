package com.example.demo.controller;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("trainees")
    public List<Trainee> getUnGroupedTraineeList(@RequestParam(value = "grouped",required = false) boolean grouped) {
        return traineeService.getUnGroupedTraineeList(grouped);
    }

    @PostMapping("/trainees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewTrainee(@RequestBody Trainee trainee) {
        traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/trainees/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTraineeById(@PathVariable Long trainee_id) {
        traineeService.deleteTraineeById(trainee_id);
    }

}
