import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorContactoTest {

    @Test
    //@Disabled
    public void shouldCreateContact(){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo","60095656", "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }

    @Test
    @DisplayName("Should Not Create Contact When First Name is Null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull(){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        Assertions.assertThrows(RuntimeException.class, ()->{
            administradorContacto.agregarContacto(null, "Carrillo","60095656", "juanpacarrillo1@gmail.com");});

    }

    @Test
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MAC OS")
    public void shouldCreateContactOnlyOnMac(){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo","60095656", "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }

    @RepeatedTest(value = 5)
    @DisplayName("Repeat Contact Creation Test 5 Times")
    public void shouldTestContactCreationRepeatedly(){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo","60095656", "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }


    @DisplayName("Repeat Contact Creation Using Value Source")
    @ParameterizedTest
    @ValueSource(strings = {"60095656", "1160095656", "abcd5656"})
    public void shouldTestContactCreationUsingValueSource(String numero){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo",numero, "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }

    @DisplayName("Repeat Contact Creation Using Method Source")
    @ParameterizedTest
    @MethodSource("phoneNumberList")
    public void shouldTestContactCreationUsingMethodSource(String numero){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo",numero, "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }

    private static List<String> phoneNumberList(){
        return Arrays.asList("60095656","60095657","60095658");
    }

    @DisplayName("Repeat Contact Creation Using Csv Source")
    @ParameterizedTest
    @CsvSource({"60095656","60095657","60095658"})
    public void shouldTestContactCreationUsingCsvSource(String numero){
        AdministradorContacto administradorContacto = new AdministradorContacto();
        administradorContacto.agregarContacto("Juan", "Carrillo",numero, "juanpacarrillo1@gmail.com");
        Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
        Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
    }

    @Nested
    class ParametrizedNestedTest{

        @DisplayName("Repeat Contact Creation Using Value Source")
        @ParameterizedTest
        @ValueSource(strings = {"60095656", "1160095656", "abcd5656"})
        public void shouldTestContactCreationUsingValueSource(String numero){
            AdministradorContacto administradorContacto = new AdministradorContacto();
            administradorContacto.agregarContacto("Juan", "Carrillo",numero, "juanpacarrillo1@gmail.com");
            Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
            Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
        }

        @DisplayName("Repeat Contact Creation Using Csv Source")
        @ParameterizedTest
        @CsvSource({"60095656","60095657","60095658"})
        public void shouldTestContactCreationUsingCsvSource(String numero){
            AdministradorContacto administradorContacto = new AdministradorContacto();
            administradorContacto.agregarContacto("Juan", "Carrillo",numero, "juanpacarrillo1@gmail.com");
            Assertions.assertFalse(administradorContacto.obtenerContactos().isEmpty());
            Assertions.assertEquals(1, administradorContacto.obtenerContactos().size());
        }


    }

}