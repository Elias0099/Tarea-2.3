package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.web.entidad.Estudiante;
import com.app.web.servicio.EstudianteServicio;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin("*")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio servicio;

    @GetMapping
    public List<Estudiante> listarEstudiantes() {
        return servicio.listarTodosLosEstudiantes();
    }

    @GetMapping("/{id}")
    public Estudiante obtenerEstudiante(@PathVariable Long id) {
        return servicio.obtenerEstudiantePorId(id);
    }

    @PostMapping
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return estudiante;
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEmail(estudiante.getEmail());
        servicio.actualizarEstudiante(estudianteExistente);
        return estudianteExistente;
    }

    @DeleteMapping("/{id}")
    public Estudiante eliminarEstudiante(@PathVariable Long id) {
        servicio.eliminarEstudiante(id);
		return null;

    }
}
