package org.activiti.springdatajpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by luisvargas on 2/3/16.
 */

@ResponseStatus(
        value = HttpStatus.METHOD_NOT_ALLOWED,
        reason = "User doesn't have enough permissions to execute this action")
class NotAllowedException extends RuntimeException {
}

@ResponseStatus(
        value = HttpStatus.NOT_ACCEPTABLE,
        reason = "Variables are invalid"
)
class NotValidProcessVariables extends RuntimeException {}