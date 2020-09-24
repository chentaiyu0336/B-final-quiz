package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.exception.TraineeNotExistException;
import com.example.demo.exception.TrainerNotExistException;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return trainer;
    }

    public void deleteTrainerById(Long id) {
        trainerRepository.findById(id).orElseThrow(()->new TrainerNotExistException("讲师不存在"));
        trainerRepository.deleteById(id);
    }
}
