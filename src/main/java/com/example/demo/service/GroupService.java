package com.example.demo.service;

import com.example.demo.domain.Groups;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.exception.CannotDivideException;
import com.example.demo.exception.GroupNotExistException;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;
    List<Groups> groupsList = new ArrayList<>();

    public GroupService(GroupRepository groupRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository) {
        this.groupRepository = groupRepository;
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
    }

    public List<Groups> divideGroup() {
        List<Trainee> allTrainees = traineeRepository.findAll();
        List<Trainer> allTrainers = trainerRepository.findAll();
        if (allTrainers.size() < 2) {
            throw new CannotDivideException("分组失败");
        }

        groupRepository.deleteAll();
        groupsList.clear();

        Collections.shuffle(allTrainees);
        Collections.shuffle(allTrainers);


        int groupCount = allTrainees.size() / 2;

        for (int i = 0; i < groupCount; i++) {
            int groupNum = i + 1;
            Trainer trainer1 = allTrainers.get(2 * i);
            Trainer trainer2 = allTrainers.get(2 * i + 1);
            trainer1.setGrouped("true");
            trainer2.setGrouped("true");
            trainerRepository.save(trainer1);
            trainerRepository.save(trainer2);
            List<Trainer> groupTrainers = new ArrayList<>();
            groupTrainers.add(trainer1);
            groupTrainers.add(trainer2);
            Groups groups = Groups.builder()
                    .name(groupNum + "组")
                    .trainers(groupTrainers)
                    .trainees(new ArrayList<>())
                    .build();
            groupsList.add(groups);
        }

        int index = 0;
        for (Trainee trainee : allTrainees) {
            trainee.setGrouped("true");
            groupsList.get(index % groupCount).getTrainees().add(trainee);
            traineeRepository.save(trainee);
            index++;
        }

        groupRepository.saveAll(groupsList);
        return groupsList;
    }

    public List<Groups> getGroups() {
        return groupRepository.findAll();
    }

    public void updateGroupName(Long id, String name) {
        Groups groups = groupRepository.findById(id).orElseThrow(()->new GroupNotExistException("该组不存在"));
        groups.setName(name);
        groupRepository.save(groups);
    }
}
