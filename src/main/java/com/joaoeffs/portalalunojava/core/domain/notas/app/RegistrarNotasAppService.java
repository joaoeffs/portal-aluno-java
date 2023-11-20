package com.joaoeffs.portalalunojava.core.domain.notas.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.notas.model.Notas;
import com.joaoeffs.portalalunojava.core.domain.notas.repository.NotasDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.RegistrarNotasUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class RegistrarNotasAppService implements RegistrarNotasUseCase {

    private final NotasDomainRepository repository;

    @Override
    public UUID handle(RegistrarNotas command) {

        var notas = Notas.builder()
            .n1(command.getN1())
            .n2(command.getN2())
            .n3(command.getN3())
            .alunoDisciplina(command.getAlunoDisciplina())
            .build();

        notas.calcularMedia();

        repository.save(notas);

        return notas.getId();
    }
}
