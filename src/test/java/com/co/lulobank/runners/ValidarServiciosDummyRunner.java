package com.co.lulobank.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/validar_servicios_dummy.feature",
        glue = "com.co.lulobank.stepdefinitions")

public class ValidarServiciosDummyRunner {
}
