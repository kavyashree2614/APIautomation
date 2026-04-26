package StepDefinitions;

import Pojo.CoinResponse;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import org.testng.Assert;

public class CoinsStepDefinition {
    private Response response;
    private CoinResponse coinResponse;

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request(String url) {
        response = given().log().all()
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.body().prettyPrint());
        coinResponse = response.as(CoinResponse.class);
    }

    @Then("Verify the response contains 3 BPIs: USD, GBP, EUR")
    public void verify_bpis() {
        Assert.assertTrue(coinResponse.getMarketData().getCurrentPrice().containsKey("usd"), "USD currency validation");
        Assert.assertTrue(coinResponse.getMarketData().getCurrentPrice().containsKey("gbp"), "GBH currency validation");
        Assert.assertTrue(coinResponse.getMarketData().getCurrentPrice().containsKey("eur"), "EUR currency validation");
    }

    @Then("Verify each cryptocurrency has market cap and total volume")
    public void verify_market_cap_and_volume() {
        Assert.assertNotNull(coinResponse.getMarketData().getMarketCap().get("usd"), "Market cap not null validation");
        Assert.assertNotNull(coinResponse.getMarketData().getTotalVolume().get("usd"), "Total volume not null validation");
    }

    @Then("Verify price change percentage over the last 24 hours is present")
    public void verify_price_change_percentage() {
        Assert.assertNotNull(coinResponse.getMarketData().getPriceChangePercentage24h(), "Price change percentage not null validation");
    }

    @Then("Verify homepage URL is not empty")
    public void verify_homepage_url() {
        Assert.assertNotNull(coinResponse.getLinks().getHomepage().get(0), "Homepage URL not null validation");
    }
}
