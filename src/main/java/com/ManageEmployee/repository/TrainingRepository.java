package com.ManageEmployee.repository;

import com.ManageEmployee.entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingEntity,Integer> {

    List<TrainingEntity> findAllByStatus(Integer status);
}
