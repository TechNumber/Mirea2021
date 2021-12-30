package com.mirea.demo.service;

import com.mirea.demo.dao.RequestRepository;
import com.mirea.demo.exception.RequestNotFoundException;
import com.mirea.demo.mapper.RequestMapper;
import com.mirea.demo.model.dto.CreatedRequestDTO;
import com.mirea.demo.model.dto.NewRequestDTO;
import com.mirea.demo.model.dto.RequestDTO;
import com.mirea.demo.model.entity.RequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestService {
    private RequestRepository requestRepository;
    private RequestMapper requestMapper;

    public CreatedRequestDTO createRequest(NewRequestDTO newRequestDTO) {
        RequestEntity entity = requestMapper.dtoToEntity(newRequestDTO);
        RequestEntity save = requestRepository.save(entity);
        return requestMapper.entityToCreatedDTO(save);
    }

    public RequestDTO getRequest(Long id) {
        RequestEntity requestEntity = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        return requestMapper.entityToDTO(requestEntity);
    }

    public String deleteRequest(Long id) {
        RequestEntity requestEntity = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        requestRepository.deleteById(id);
        return String.format("Request with id = %d was successfully deleted", id);
    }

    public RequestDTO putRequest(Long id, NewRequestDTO updatedRequestDTO) {
        RequestEntity requestEntity = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        requestEntity = requestMapper.dtoToEntity(updatedRequestDTO);
        requestEntity.setId(id);
        requestRepository.save(requestEntity);
        return requestMapper.entityToDTO(requestEntity);
    }

}
