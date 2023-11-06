package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.notas.projection.ListagemNotas;

public interface AlunoDisciplinaQueryRepository extends Repository<AlunoDisciplinaQuery, UUID> {

    @Query(value = "SELECT * FROM aluno_disciplina WHERE disciplina_id = ?1", nativeQuery = true)
    List<AlunoDisciplinaQuery> findByDisciplina(UUID disciplinaId);

    @Query(value = """
        select
        	cast(ad.id AS varchar) AS id,
        	cast(n.id AS varchar) AS notaId,
        	n.n1 as N1,
        	n.n2 as N2,
        	n.n3 as N3,
        	cast(a.id AS varchar) AS alunoId,
        	a.nome as nome,
         	a.sobrenome as sobrenome,
         	a.matricula as matricula
        from
        	aluno_disciplina ad
        left join notas n on
        	ad.id = n.aluno_disciplina_id
        left join aluno a on
         	ad.aluno_id = a.id
        where
        	ad.disciplina_id = :disciplinaId
        """, nativeQuery = true)
    List<ListagemNotas> listarNotasByDisciplina(UUID disciplinaId);
}
