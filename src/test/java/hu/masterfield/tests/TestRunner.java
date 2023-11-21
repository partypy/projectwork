package hu.masterfield.tests;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "/src/test/recources/features/acceptcookie.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:reports/result.html")
public class TestRunner {
}
