package com.co.lulobank.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    EnvironmentVariables environmentVariable;

    @Before
    public void configurarUrlBase() {
        environmentVariable = Injectors.getInjector().getInstance(EnvironmentVariables.class);
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("René").whoCan(CallAnApi.at(environmentVariable.getProperty("environments.default.baseurl")));
    }
}
