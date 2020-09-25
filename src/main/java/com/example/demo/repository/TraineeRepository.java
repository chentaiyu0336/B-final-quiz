package com.example.demo.repository;

import com.example.demo.domain.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long> {
    //TODO GTB: 删掉无必要的注释
//    private static List<Trainee> traineeList = new ArrayList<Trainee>();
//
//    {
//        traineeList.add(new Trainee(1, "沈乐棋", "male", null));
//        traineeList.add(new Trainee(2, "徐慧慧", "female", null));
//        traineeList.add(new Trainee(3, "陈思聪", "male", null));
//        traineeList.add(new Trainee(4, "王江林", "male", null));
//        traineeList.add(new Trainee(5, "王登宇", "male", null));
//        traineeList.add(new Trainee(6, "杨思雨", "male", null));
//        traineeList.add(new Trainee(7, "江雨舟", "male", null));
//        traineeList.add(new Trainee(8, "廖燊", "male", null));
//        traineeList.add(new Trainee(9, "胡晓", "female", null));
//        traineeList.add(new Trainee(10, "但杰", "male", null));
//        traineeList.add(new Trainee(11, "盖迈达", "male", null));
//        traineeList.add(new Trainee(12, "肖美琦", "female", null));
//        traineeList.add(new Trainee(13, "黄云洁", "female", null));
//        traineeList.add(new Trainee(14, "齐瑾浩", "male", null));
//        traineeList.add(new Trainee(15, "刘亮亮", "male", null));
//        traineeList.add(new Trainee(16, "肖逸凡", "male", null));
//        traineeList.add(new Trainee(17, "王作文", "male", null));
//        traineeList.add(new Trainee(18, "郭瑞凌", "male", null));
//        traineeList.add(new Trainee(19, "李明豪", "male", null));
//        traineeList.add(new Trainee(20, "党泽", "male", null));
//    }

}
