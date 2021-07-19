package br.maua.forum.repository;

import br.maua.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Tipo da PK = Long
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Acha o atributo nome que está dentro do Curso (Para garantir -> findByCurso_Nome)
    List<Topico> findByCursoNome(String nomeCurso);

    /*
        @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
        List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
     */
}
