package com.emailsender.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDto {

    private String toEmail;

    private String mailText;

    private String mailSubject;

}
