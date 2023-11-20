package com.joaoeffs.portalalunojava.query.domain.notas.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection.ListagemNotasAlunos;
import com.joaoeffs.portalalunojava.query.domain.notas.model.NotasQuery;
import com.joaoeffs.portalalunojava.query.domain.notas.projection.ListagemNotas;

public interface NotasQueryRepository extends Repository<NotasQuery, UUID> {

    Optional<ListagemNotas> findById(UUID id);

    @Query(value = """
        select
            cast(n.id AS varchar) AS id,
        	n.n1 as N1,
        	n.n2 as N2,
        	n.n3 as N3,
        	n.media as media,
        	n.situacao as situacao,
        	d.nome as nomeDisciplina
        from
        	notas n
        left join aluno_disciplina ad on
        	n.aluno_disciplina_id = ad.id
        left join disciplina d on
        	ad.disciplina_id = d.id
        left join usuario u on ad.aluno_id = u.id
        	where ad.aluno_id = :usuario
        """, nativeQuery = true)
    List<ListagemNotasAlunos> listarNotasByAluno(UUID usuario);
}
