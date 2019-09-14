package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.TrainingEmployeeConvert;
import com.ManageEmployee.dto.TrainingEmployeeDTO;
import com.ManageEmployee.entity.TrainingEmployeeEntity;
import com.ManageEmployee.repository.TrainingEmployeeRepository;
import com.ManageEmployee.service.ITrainingEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingEmployeeServiceImpl implements ITrainingEmployeeService {
    @Autowired
    private TrainingEmployeeRepository trainingEmployeeRepository;
    @Autowired
    private TrainingEmployeeConvert convert;
    @Override
    public List<TrainingEmployeeDTO> findAll() {
        return trainingEmployeeRepository.findAll().stream().map(item-> convert.convertToDTO(item)).
                collect(Collectors.toList());
    }

    @Override
    public TrainingEmployeeDTO findById(Integer id) {
        TrainingEmployeeEntity trainingEmployee = trainingEmployeeRepository.findById(id).get();
        return trainingEmployee!=null ? convert.convertToDTO(trainingEmployee) : null;
    }

    @Override
    public void deleteById(Integer id) {
        if (id!=null && findById(id)!=null){
            trainingEmployeeRepository.deleteById(id);
        }
    }

    @Override
    public TrainingEmployeeDTO save(TrainingEmployeeDTO trainingEmployeeDTO) {
        if(trainingEmployeeDTO.getId()==null){
            TrainingEmployeeEntity trainingEmployee = convert.convertToEntity(trainingEmployeeDTO);
            Calendar calendar = Calendar.getInstance();
            trainingEmployee.setStartDate(calendar.getTime());
            calendar.add(Calendar.MONTH,trainingEmployee.getTraining().getTotalTime());
            trainingEmployee.setEndDate(calendar.getTime());
            trainingEmployee = trainingEmployeeRepository.save(trainingEmployee);
            return convert.convertToDTO(trainingEmployee);
        }
        return null;
    }

    @Override
    public TrainingEmployeeDTO update(TrainingEmployeeDTO trainingEmployeeDTO) {
        if(trainingEmployeeDTO.getId()!=null){
            TrainingEmployeeEntity trainingEmployeeInDb = trainingEmployeeRepository.getOne(trainingEmployeeDTO.getId());
            TrainingEmployeeEntity trainingEmployee = convert.convertToEntity(trainingEmployeeDTO);
            trainingEmployee.setCreatedBy(trainingEmployeeInDb.getCreatedBy());
            trainingEmployee.setCreatedDate(trainingEmployeeInDb.getCreatedDate());
            trainingEmployee.setStartDate(trainingEmployeeInDb.getStartDate());
            trainingEmployee.setEndDate(trainingEmployee.getEndDate());
            return convert.convertToDTO(trainingEmployeeRepository.save(trainingEmployee));
        }
        return null;
    }

    @Override
    public List<TrainingEmployeeDTO> findByByTraining_id(Integer id) {
        return trainingEmployeeRepository.findAllByTraining_Id(id)
                .stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }
}
