package com.mirea.demo.controller;

import com.mirea.demo.model.dto.CreatedRequestDTO;
import com.mirea.demo.model.dto.DemoResponse;
import com.mirea.demo.model.dto.NewRequestDTO;
import com.mirea.demo.model.dto.RequestDTO;
import com.mirea.demo.service.RequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/demo")
@Api(tags = "Методы контроллера")
@AllArgsConstructor
public class RequestController {
    private RequestService requestService;

    @PostMapping
    @ApiOperation(value = "Запись запроса в базу данных",
            notes = "Запись запроса в БД и получение созданного объекта")
    public DemoResponse<CreatedRequestDTO> createRequest(@RequestBody NewRequestDTO newRequestDTO) {
        CreatedRequestDTO request = requestService.createRequest(newRequestDTO);
        return DemoResponse.ok(request);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Получение данных запроса",
            notes = "Получение данных запроса по идентификатору")
    public DemoResponse<RequestDTO> getRequest(@ApiParam("Идентификатор запроса") @PathVariable Long id) {
        return DemoResponse.ok(requestService.getRequest(id));
    }

    @DeleteMapping("{name}")
    @ApiOperation(value = "Получение delete-запроса",
            notes = "Получение delete-запроса")
    public ResponseEntity<String> deleteRequest(@ApiParam("Идентификатор запроса") @PathVariable String name) {
        return ResponseEntity.ok(String.format("%s was deleted", name));
    }

    @PutMapping("{name}")
    @ApiOperation(value = "Получение put-запроса",
            notes = "Получение put-запроса")
    public ResponseEntity<String> putRequest(@ApiParam("Идентификатор запроса") @PathVariable String name) {
        return ResponseEntity.ok(String.format("%s was updated", name));
    }
}
