package com.ManageEmployee.service.impl;

import com.ManageEmployee.convert.TrainingConvert;
import com.ManageEmployee.dto.TrainingDTO;
import com.ManageEmployee.entity.TrainingEntity;
import com.ManageEmployee.repository.TrainingRepository;
import com.ManageEmployee.service.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TrainingServiceImpl implements ITrainingService {
    @Autowired
    private TrainingRepository trainingRepository;
    @Autowired
    private TrainingConvert convert;
    @Override
    public List<TrainingDTO> findAll() {
        return trainingRepository.findAll().stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public TrainingDTO findById(Integer id) {
        TrainingEntity trainingEntity = trainingRepository.findById(id).get();
        return trainingEntity!=null?convert.convertToDTO(trainingEntity):null;
    }

    @Override
    public void deleteById(Integer id) {
        if(id!=null&&findById(id)!=null)
        trainingRepository.deleteById(id);
    }

    @Override
    public TrainingDTO save(TrainingDTO trainingDTO) {
        TrainingEntity trainingEntity = convert.convertToEntity(trainingDTO);
        trainingEntity= trainingRepository.save(trainingEntity);
        return convert.convertToDTO(trainingEntity);
    }

    @Override
    public TrainingDTO update(TrainingDTO trainingDTO) {
        if (trainingDTO.getId()!=null){
            TrainingEntity trainingEntity = convert.convertToEntity(trainingDTO);
            TrainingEntity trainingEntityInDB = trainingRepository.findById(trainingDTO.getId()).get();
            trainingEntity.setCreatedBy(trainingEntityInDB.getCreatedBy());
            trainingEntity.setCreatedDate(trainingEntityInDB.getCreatedDate());
            trainingEntity = trainingRepository.save(trainingEntity);
            return  convert.convertToDTO(trainingEntity);
        }
        return null;
    }

    @Override
    public List<TrainingDTO> findAllByStatus(Integer id) {
        return trainingRepository.findAllByStatus(id)
                .stream().map(item-> convert.convertToDTO(item)).collect(Collectors.toList());
    }
}
