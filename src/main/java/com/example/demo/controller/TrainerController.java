package com.example.demo.controller;

import com.example.demo.domain.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainers")
@CrossOrigin
public class TrainerController {
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //TODO GTB：BUG，当自动分组完成后，已经被分组的讲师，仍然会出现在这个list中
    @GetMapping("")
    public List<Trainer> getUnGroupedTrainerList(@RequestParam(value = "grouped",required = false) String grouped) {
        return trainerService.getUnGroupedTrainerList(grouped);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer addNewTrainer(@RequestBody @Valid Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping("/{trainer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainerById(@PathVariable Long trainer_id) {
        trainerService.deleteTrainerById(trainer_id);
    }



}
