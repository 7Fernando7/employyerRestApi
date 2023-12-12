package org.example.services;


import org.example.dtos.EmployeerDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeersService {

    List<EmployeerDTO> getAllEmployees();

    EmployeerDTO getEmployeeById(int employeerId);

    EmployeerDTO obtenerPorId(int employeerId);

    void saveEmployeer(EmployeerDTO employeer);

    void eliminarEmployeer(int employeerId);

    void updateEmployeer(int employeerId, EmployeerDTO employeerDTO);
}
