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

/**
 *
 * @author CltControl
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of MakeFormula method, of class Operations.
     */
  @Test
    public void testMakeFormula() {
        System.out.println("testMakeFormula");

        // Llamamos al método MakeFormula
        String result = Operations.MakeFormula();

        // Validamos que la fórmula no sea nula ni vacía
        assertNotNull(result, "La fórmula no debe ser nula");
        assertFalse(result.isEmpty(), "La fórmula no debe estar vacía");

        // Validamos que la fórmula tenga el formato esperado (números y operadores)
        // La fórmula debe contener un número seguido de un operador, y luego un número nuevamente
        assertTrue(result.matches("\\d+([+\\-*/]\\d+)+"), "La fórmula generada no tiene el formato esperado");
    }
    /**
     * Test of Solve method, of class Operations.
     */
 @Test
    public void testSolve() {
        System.out.println("testSolve");

        // Probamos con una fórmula sencilla: "3+2*2"
        String formula = "3+2*2";
        String expectedResult = "3+2*2=7";  // El resultado esperado es 7 (por la precedencia de multiplicación)
        String result = Operations.Solve(formula);

        // Verificamos que el resultado calculado sea el esperado
        assertEquals(expectedResult, result);

        // Probamos otra fórmula con una operación diferente: "10-5/5"
        formula = "10-5/5";
        expectedResult = "10-5/5=9";  // 10 - (5 / 5) = 9
        result = Operations.Solve(formula);

        assertEquals(expectedResult, result);

        // Probamos con una fórmula que solo tenga una operación: "5*5"
        formula = "5*5";
        expectedResult = "5*5=25";  // 5 * 5 = 25
        result = Operations.Solve(formula);

        assertEquals(expectedResult, result);

        // Probamos con una fórmula con división: "9/3"
        formula = "9/3";
        expectedResult = "9/3=3";  // 9 / 3 = 3
        result = Operations.Solve(formula);

        assertEquals(expectedResult, result);
    }
    
}
