package org.adaca.exam.adacaexamprojectmanagementtool.shared.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
    private String message;
}
