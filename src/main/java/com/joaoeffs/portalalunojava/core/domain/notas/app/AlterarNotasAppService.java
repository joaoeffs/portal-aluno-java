package com.joaoeffs.portalalunojava.core.domain.notas.app;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoeffs.portalalunojava.core.domain.notas.repository.NotasDomainRepository;
import com.joaoeffs.portalalunojava.core.domain.notas.usecase.AlterarNotasUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class AlterarNotasAppService implements AlterarNotasUseCase {

    private final NotasDomainRepository repository;

    @Override
    public UUID handle(AlterarNotas command) {

        var notas = repository.findById(command.getId());

        notas.alterar()
            .n1(command.getN1())
            .n2(command.getN2())
            .n3(command.getN3())
            .apply();

        notas.calcularMedia();

        repository.save(notas);

        return notas.getId();
    }
}
