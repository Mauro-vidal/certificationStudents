package com.mauro.certification.modules.students.entity.questions.repositories;

import com.mauro.certification.modules.students.entity.questions.entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository  extends JpaRepository<QuestionEntity, UUID> {

    List<QuestionEntity>findByTechnology(String technology);
}
