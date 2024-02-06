package com.mauro.certification.modules.students.entity.useCases.services;

import com.mauro.certification.modules.students.entity.dto.VerifyHasCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHaCertificationUseCase {
    public boolean execute(VerifyHasCertificationDTO dto) {
        if (dto.getEmail().equals("danieleleao@gmail.com") && dto.getTechnology().equals("JAVA")) {
            return true;
        }

        return false;

    }

}
