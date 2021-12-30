package com.mirea.demo.mapper;

import com.mirea.demo.model.dto.CreatedRequestDTO;
import com.mirea.demo.model.dto.NewRequestDTO;
import com.mirea.demo.model.dto.RequestDTO;
import com.mirea.demo.model.entity.RequestEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RequestMapper {
    RequestEntity dtoToEntity(NewRequestDTO newRequestDTO);

    CreatedRequestDTO entityToCreatedDTO(RequestEntity requestEntity);

    RequestDTO entityToDTO(RequestEntity requestEntity);
}
