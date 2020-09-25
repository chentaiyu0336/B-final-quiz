package com.example.demo.controller;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trainees")
@CrossOrigin
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    //TODO GTB: 如果path为空，可以不写""
    @GetMapping("")
    public List<Trainee> getUnGroupedTraineeList(@RequestParam(value = "grouped",required = false) String grouped) {
        return traineeService.getUnGroupedTraineeList(grouped);
    }

    //TODO GTB: 如果path为空，可以不写""
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee addNewTrainee(@RequestBody @Valid Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //TODO GTB：组合词，后端一般使用驼峰形式。
    public void deleteTraineeById(@PathVariable Long trainee_id) {
        traineeService.deleteTraineeById(trainee_id);
    }

}
