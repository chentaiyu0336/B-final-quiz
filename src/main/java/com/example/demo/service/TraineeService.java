package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }


    public void addTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTraineeById(Long id) {
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getUnGroupedTraineeList(boolean grouped) {
        List<Trainee> allTrainee=traineeRepository.findAll();
        return allTrainee.stream().filter(trainee -> trainee.isGrouped()==grouped).collect(Collectors.toList());
    }
}