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

    @DeleteMapping("{id}")
    @ApiOperation(value = "Удаление запроса из базы данных",
            notes = "Получение идентификатора запроса и его удаление из БД с возвратом тела запроса")
    public DemoResponse<RequestDTO> deleteRequest(@ApiParam("Идентификатор запроса") @PathVariable Long id) {
        return DemoResponse.ok(requestService.deleteRequest(id));
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Обновление данных запроса",
            notes = "Получение идентификатора запроса и его обновление по переданным данным")
    public DemoResponse<RequestDTO> putRequest(@ApiParam("Идентификатор запроса") @PathVariable Long id, @RequestBody NewRequestDTO newRequestDTO) {
        return DemoResponse.ok(requestService.putRequest(id, newRequestDTO));
    }
}
