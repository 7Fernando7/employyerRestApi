package org.example.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.dtos.EmployeerDTO;
import org.example.mappers.EmployeerMapper;
import org.example.services.EmployeersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class EmployeersController {
    @Autowired
    private EmployeersServiceImpl employeerService;
    @Autowired
    private EmployeerMapper employeerMapper;

    @GetMapping("/employeers")
    public List<EmployeerDTO> getAllEmployees() {
        return employeerService.getAllEmployees();
    }

    @GetMapping("/employeers/{employeerId}")
    public ResponseEntity<EmployeerDTO> getEmployeeById(@PathVariable int employeerId) {
        EmployeerDTO employeerDTO = employeerService.getEmployeeById(employeerId);
        if (employeerDTO == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employeerDTO);
        }
    }

    @PostMapping("/employeers")
    public ResponseEntity<Void> saveEmployeer(@RequestBody EmployeerDTO employeer) {
        employeerService.saveEmployeer(employeer);

        return new ResponseEntity<>(HttpStatus.OK.CREATED);
    }

    @PutMapping("/employeers/{id}")
    public ResponseEntity<Void> actualizarEmployeer(@PathVariable(name = "id") int employeerId, @RequestBody EmployeerDTO employeerDTO) {
        try {
            employeerService.updateEmployeer(employeerId, employeerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/employeers/{id}")
    public ResponseEntity eliminarEmployeer(@PathVariable(name = "id") int employeerId) {
        this.employeerService.eliminarEmployeer(employeerId);
        return ResponseEntity.ok().build();
    }
}
