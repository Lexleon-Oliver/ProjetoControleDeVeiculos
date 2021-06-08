package com.orangetalents.cadastrodeveiculos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessageResponse {

    private int status;

//    private String code;

    private String message;

    private String title;

    private String type;
}
