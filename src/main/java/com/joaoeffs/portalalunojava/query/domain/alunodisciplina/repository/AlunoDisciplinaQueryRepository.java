package com.joaoeffs.portalalunojava.query.domain.alunodisciplina.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.model.AlunoDisciplinaQuery;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection.ListagemAlunoDisciplina;
import com.joaoeffs.portalalunojava.query.domain.alunodisciplina.projection.ListagemNotasAlunos;

public interface AlunoDisciplinaQueryRepository extends Repository<AlunoDisciplinaQuery, UUID> {

    @Query(value = "SELECT * FROM aluno_disciplina WHERE disciplina_id = ?1", nativeQuery = true)
    List<AlunoDisciplinaQuery> findByDisciplina(UUID disciplinaId);

    Optional<ListagemAlunoDisciplina> findById(UUID id);

    @Query(value = """
        select
        	cast(ad.id AS varchar) AS id,
        	cast(n.id AS varchar) AS notaId,
        	n.n1 as N1,
        	n.n2 as N2,
        	n.n3 as N3,
        	n.media as media,
        	n.situacao as situacao,
        	cast(a.id AS varchar) AS alunoId,
        	a.nome as nome,
         	a.sobrenome as sobrenome,
         	a.matricula as matricula,
         	d.nome as nomeDisciplina,
         	d.codigo as codigoDisciplina
        from
        	aluno_disciplina ad
        left join notas n on
        	ad.id = n.aluno_disciplina_id
        left join usuario a on
         	ad.aluno_id = a.id
        left join disciplina d on
            ad.disciplina_id = d.id
        where
        	ad.disciplina_id = :disciplinaId
        """, nativeQuery = true)
    List<ListagemNotasAlunos> listarNotasByDisciplina(UUID disciplinaId);
}
