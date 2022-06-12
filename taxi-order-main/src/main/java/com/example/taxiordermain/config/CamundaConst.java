package com.example.taxiordermain.config;

import lombok.experimental.UtilityClass;
import org.camunda.community.rest.client.dto.ProcessDefinitionDto;

@UtilityClass
public class CamundaConst {
    public static class Proc {
        public static final ProcessDefinitionDto REGISTRATION = new ProcessDefinitionDto()
                .key("registration_process")
                .tenantId("1")
                .id("f4988763-e82a-11ec-adb2-0242ac180002")
                .name("Taxi process");
    }
    public static class Var {
        public static final String TAXI_USER = "taxi_user";
    }
}
