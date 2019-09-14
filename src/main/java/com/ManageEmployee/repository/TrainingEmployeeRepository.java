package com.ManageEmployee.repository;

import com.ManageEmployee.entity.TrainingEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainingEmployeeRepository extends JpaRepository<TrainingEmployeeEntity,Integer>{
    List<TrainingEmployeeEntity> findAllByTraining_Id(Integer trainingId);
}
