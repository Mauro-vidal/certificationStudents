package com.mauro.certification.modules.students.entity.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResultDto {

    private UUID id;
    private String technology;
    private String description;
    private List<AlternativeResultDto> alternatives;
}
