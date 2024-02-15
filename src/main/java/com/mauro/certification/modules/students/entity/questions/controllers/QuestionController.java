package com.mauro.certification.modules.students.entity.questions.controllers;

import com.mauro.certification.modules.students.entity.questions.dto.AlternativeResultDto;
import com.mauro.certification.modules.students.entity.questions.dto.QuestionResultDto;
import com.mauro.certification.modules.students.entity.questions.entities.AlternativesEntity;
import com.mauro.certification.modules.students.entity.questions.entities.QuestionEntity;
import com.mauro.certification.modules.students.entity.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDto> findByTechnology(@PathVariable String technology) {

        System.out.println("TECH === " + technology);

        var result = this.questionRepository.findByTechnology(technology);

        var toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());


        return toMap;
    }




    static QuestionResultDto mapQuestionToDTO(QuestionEntity question) {

        var questionResultDto = QuestionResultDto.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        List<AlternativeResultDto> alternativeResultDtos = question.getAlternatives().stream().map(alternative -> mapAlternativeDto(alternative)).collect(Collectors.toList());

        questionResultDto.setAlternatives(alternativeResultDtos);
        return questionResultDto;


    }

    static AlternativeResultDto mapAlternativeDto(AlternativesEntity alternativesResultDto) {

        return AlternativeResultDto.builder().id(alternativesResultDto.getId()).description(alternativesResultDto.getDescription()).build();

    }


}
