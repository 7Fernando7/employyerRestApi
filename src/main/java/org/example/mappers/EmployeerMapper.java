package org.example.mappers;

import org.example.dtos.EmployeerDTO;
import org.example.entities.EmployeerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeerMapper {
    EmployeerDTO mapToEmployeerDto(EmployeerEntity employeer);
    EmployeerEntity mapToEmployeerEntity(EmployeerDTO employeerDTO);
}
