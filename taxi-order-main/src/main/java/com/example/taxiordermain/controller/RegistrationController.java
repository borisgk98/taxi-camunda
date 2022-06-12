package com.example.taxiordermain.controller;

import com.example.taxiordermain.config.CamundaConst;
import com.example.taxiordermain.model.dto.TaxiUserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.dto.VariableValueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final ProcessDefinitionApi processDefinitionApi;
    private final ObjectMapper objectMapper;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<String> registration(@RequestBody TaxiUserDto taxiUserDto) {
        processDefinitionApi.startProcessInstanceByKeyAndTenantId(
                CamundaConst.Proc.REGISTRATION.getKey(),
                CamundaConst.Proc.REGISTRATION.getTenantId(),
                new StartProcessInstanceDto()
                        .variables(Map.of(
                                CamundaConst.Var.TAXI_USER, new VariableValueDto().value(objectMapper.writeValueAsString(taxiUserDto))
                        ))
        );
        return ResponseEntity.noContent().build();
    }

}
