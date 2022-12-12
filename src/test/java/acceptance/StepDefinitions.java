package acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


/** Steps definitions for calculator.feature */
public class StepDefinitions {
    private String server = System.getProperty("calculator.url");

    private RestTemplate restTemplate = new RestTemplate();

    private int a;
    private int b;
    private int result;

    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers(int a, int b) throws Throwable {
        System.out.println(server);
        System.out.println("#########");
        this.a = a;
        this.b = b;
    }

    @When("^the calculator sums them$")
    public void the_calculator_sums_them() throws Throwable {
        String url = String.format("%s/sum?a=%d&b=%d", server, a, b);
        System.out.println(url);
        System.out.println("#########");
        result = restTemplate.getForObject(url, Integer.class);
   //     result = a + b;
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(int expectedResult) throws Throwable {
        assertEquals(expectedResult, result);
    }
}
