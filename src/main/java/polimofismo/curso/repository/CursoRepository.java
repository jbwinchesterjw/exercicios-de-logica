package polimofismo.curso.repository;


import polimofismo.curso.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    List<Curso> cursoList = new ArrayList<>();

    public void cadastroCurso(Curso curso){
        cursoList.add(curso);
    }

    public List<Curso> listarCursosRepositorio(){
        return cursoList;
    }
}
