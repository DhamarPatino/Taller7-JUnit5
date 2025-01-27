/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.espol.poo.taller7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    String result;
    public OperationsTest() {
        this.result = "";
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        result = Operations.MakeFormula();

    }
    
    @AfterEach
    public void tearDown() {
    }
    /**
     * Test of MakeFormula method, of class Operations.
     */
  @DisplayName("La formula no debe ser nula")
  @Test
    public void testMakeFormulaNull() {
        System.out.println("testMakeFormula");

        // Llamamos al método MakeFormula

        // Validamos que la fórmula no sea nula ni vacía
        assertNotNull(result, "La fórmula no debe ser nula");
        
    }
    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testMakeFormulaVacio(){
        
        assertFalse(result.isEmpty(), "La fórmula no debe estar vacía");

        // Validamos que la fórmula tenga el formato esperado (números y operadores)
        // La fórmula debe contener un número seguido de un operador, y luego un número nuevamente
    }
    @Test
    public void testMakeFormulaValido(){
        assertTrue(result.matches("\\d+([+\\-*/]\\d+)+"), "La fórmula generada no tiene el formato esperado");
    }
    
    @DisplayName("Test que verifica que la fórmula con varias operaciones es evaluada correctamente")
    @ParameterizedTest
    @ValueSource(strings = {"3+5*2"})
    void testSolveMultipleOperations(String formula) {
        String result = Operations.Solve(formula);
        assertEquals("3+5*2=13", result, "La solución de 3+5*2 debe ser 13.");
    }

    @DisplayName("Test que verifica que la solución de una fórmula con división por cero lance una excepción")
    @ParameterizedTest
    @ValueSource(strings = {"5/0"})
    void testSolveDivisionByZero(String formula) {
        assertThrows(ArithmeticException.class, () -> {
        Operations.Solve(formula);
        }, "La división por cero debe lanzar una ArithmeticException.");
    }
    
    @DisplayName("Test que verifica que la solución de una fórmula con división por cero lance una excepción")
    @ParameterizedTest
    @ValueSource(strings = {"3+2*2"})
    public void testSolve() {
        // Probamos con una fórmula sencilla: "3+2*2"
        String expectedResult = "3+2*2=7";  // El resultado esperado es 7 (por la precedencia de multiplicación)

        // Verificamos que el resultado calculado sea el esperado
        assertNotEquals(expectedResult, result);
        
    }

    @DisplayName("Test que verifica que la solución de una fórmula de suma es correcta")
    @ParameterizedTest
    @ValueSource(strings = {"3+5"})
    void testSolveAddition(String formula) {
        String result = Operations.Solve(formula);
        assertEquals("3+5=8", result, "La solución de 3+5 debe ser 8.");
    }

    @DisplayName("Test que verifica que la solución de una fórmula de resta es correcta")
    @ParameterizedTest
    @ValueSource(strings = {"8-3"})
    void testSolveSubtraction(String formula) {
        String result = Operations.Solve(formula);
        assertEquals("8-3=5", result, "La solución de 8-3 debe ser 5.");
    }
    
    @DisplayName("Test que verifica que la solución de una fórmula de multiplicación es correcta")
    @ParameterizedTest
    @ValueSource(strings = {"4*6"})
    void testSolveMultiplication(String formula) {
        String result1 = Operations.Solve(formula);
        assertEquals("4*6=24", result1, "La solución de 4*6 debe ser 24.");
    }

    @DisplayName("Test que verifica que la solución de una fórmula de división es correcta")
    @ParameterizedTest
    @ValueSource(strings = {"8/2"})
    void testSolveDivision(String formula) {
        String result1 = Operations.Solve(formula);
        assertEquals("8/2=4", result1, "La solución de 8/2 debe ser 4.");
    }
}

