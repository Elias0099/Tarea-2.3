package com.app.web.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.EstudianteRepositorio;

@SpringBootTest
public class EstudianteServicioTest {

    @Test
    public void testGuardarEstudiante() {
        // Crear un mock del repositorio de estudiantes
        EstudianteRepositorio repositorioMock = mock(EstudianteRepositorio.class);
        
        // Crear un estudiante de ejemplo
        Estudiante estudiante = new Estudiante("John", "Doe", "john@example.com");
        
        // Configurar el comportamiento del mock para que devuelva el estudiante de ejemplo cuando se llame a save
        when(repositorioMock.save(estudiante)).thenReturn(estudiante);
        
        // Crear el servicio de estudiantes con el mock del repositorio
        EstudianteServicio servicio = new EstudianteServicioImpl(repositorioMock);
        
        // Llamar al método que se está probando
        Estudiante estudianteGuardado = servicio.guardarEstudiante(estudiante);
        
        // Verificar que se devolvió un estudiante
        assertNotNull(estudianteGuardado);
        
        // Verificar que los atributos del estudiante guardado son los mismos que los del estudiante original
        assertEquals("John", estudianteGuardado.getNombre());
        assertEquals("Doe", estudianteGuardado.getApellido());
        assertEquals("john@example.com", estudianteGuardado.getEmail());
        
        // Verificar que se llamó al método save del repositorio
        verify(repositorioMock).save(estudiante);
    }

    @Test
    public void testActualizarEstudiante() {
        // Crear un mock del repositorio de estudiantes
        EstudianteRepositorio repositorioMock = mock(EstudianteRepositorio.class);
        
        // Crear un estudiante de ejemplo
        Estudiante estudiante = new Estudiante(1L, "John", "Doe", "john@example.com");
        
        // Configurar el comportamiento del mock para que devuelva el estudiante de ejemplo cuando se llame a save
        when(repositorioMock.save(estudiante)).thenReturn(estudiante);
        
        // Crear el servicio de estudiantes con el mock del repositorio
        EstudianteServicio servicio = new EstudianteServicioImpl(repositorioMock);
        
        // Llamar al método que se está probando
        Estudiante estudianteActualizado = servicio.actualizarEstudiante(estudiante);
        
        // Verificar que se devolvió un estudiante
        assertNotNull(estudianteActualizado);
        
        // Verificar que los atributos del estudiante actualizado son los mismos que los del estudiante original
        assertEquals(1L, estudianteActualizado.getId());
        assertEquals("John", estudianteActualizado.getNombre());
        assertEquals("Doe", estudianteActualizado.getApellido());
        assertEquals("john@example.com", estudianteActualizado.getEmail());
        
        // Verificar que se llamó al método save del repositorio
        verify(repositorioMock).save(estudiante);
    }
}
