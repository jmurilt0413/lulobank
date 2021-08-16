package com.co.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    EnvironmentVariables environmentVariable;
    String urlBase;

    @Before
    public void configurarUrlBase() {
        final String RUTA_URL = "baseurl";
        environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        urlBase = EnvironmentSpecificConfiguration.from(environmentVariable).getProperty(RUTA_URL);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("René").whoCan(CallAnApi.at(urlBase));
    }
}
