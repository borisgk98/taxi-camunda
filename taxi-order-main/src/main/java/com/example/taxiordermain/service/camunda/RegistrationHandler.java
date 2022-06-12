package com.example.taxiordermain.service.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Service;

@Service
@ExternalTaskSubscription("validation")
@Slf4j
public class RegistrationHandler implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        log.info("\n***** Start Validation with BusinessKey={} *****", externalTask.getBusinessKey());

        var taskVariables = externalTask.getAllVariables();
        log.info("All camunda variables: ");
        taskVariables.forEach((key, value) -> log.info("\"{}\": \"{}\"", key, value));

        // complete the external task
        externalTaskService.complete(externalTask, taskVariables);

        log.info("\n***** End Validation task *****");
    }
}
