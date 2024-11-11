package com.srs.REST.API.services;

import com.srs.REST.API.dto.EmployeeDTO;
import com.srs.REST.API.entities.EmployeeEntity;
import com.srs.REST.API.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EmployeeService {

//    @Autowired < constructor cause variables should not be changed and should be final
//    final initialize the fields once inside constructor
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    // constructor
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.getById(id);
//        return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getDateOfJoining(), employeeEntity.isActive());
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    // why remap employeeEntity?
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                                 .stream()
                                 .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                                  .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
