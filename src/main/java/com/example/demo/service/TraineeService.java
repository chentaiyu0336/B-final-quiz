package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

//    public List<Trainee> getTraineeList(String gender) {
//        if (gender == null)
//            return traineeRepository.getStudentList();
//        else
//            return traineeRepository.filterStudentsByGender(gender);
//    }

    public void addTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
    }

    public void deleteTraineeById(Long id) {
        traineeRepository.deleteById(id);
    }

}
