package acceptance;


import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

/** Acceptance Test */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("acceptance")
@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "acceptance"
        )
public class AcceptanceIT { }
