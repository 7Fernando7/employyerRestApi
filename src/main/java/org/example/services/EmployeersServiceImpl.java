package org.example.services;


import org.example.dtos.EmployeerDTO;
import org.example.entities.EmployeerEntity;
import org.example.mappers.EmployeerMapper;
import org.example.repositories.EmployeersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeersServiceImpl implements EmployeersService {

    @Autowired
    private EmployeersRepository employeersRepository;
    @Autowired
    private EmployeerMapper employeerMapper;

    @Autowired
    public List<EmployeerDTO> getAllEmployees() {
        List<EmployeerEntity> employeers = employeersRepository.findAll();
        return employeers.stream().map(employeerMapper::mapToEmployeerDto).collect(Collectors.toList());
    }

    @Override
    public EmployeerDTO getEmployeeById(int employeerId) {

        Optional<EmployeerEntity> employeeOptional = employeersRepository.findById(employeerId);
        if (employeeOptional.isPresent()) {
            return employeerMapper.mapToEmployeerDto(employeeOptional.get());
        } else {
            return null;
        }
    }

    public EmployeerDTO obtenerPorId(int employeerId) {
        return employeerMapper.mapToEmployeerDto(employeersRepository.findById(employeerId).orElse(null));
    }

    @Override
    public void saveEmployeer(EmployeerDTO employeer) {
        EmployeerEntity employeerEntity = employeerMapper.mapToEmployeerEntity(employeer);
        employeersRepository.save(employeerEntity);
    }

    @Override
    public void eliminarEmployeer(int employeerId) {
        employeersRepository.deleteById(employeerId);
    }


    public void updateEmployeer(int employeerId, EmployeerDTO employeerDTO) {
        Optional<EmployeerEntity> employeerOpt = employeersRepository.findById(employeerId);
        if (!employeerOpt.isPresent()) {
            throw new RuntimeException("Employeer not found with id " + employeerId);
        }

        EmployeerEntity employeer = employeerOpt.get();
        employeer.setAge(employeerDTO.getAge());
        employeer.setName(employeerDTO.getName());
        employeer.setSalary(employeerDTO.getSalary());
        employeer.setPosition(employeerDTO.getPosition());

        employeersRepository.save(employeer);

    }
}
