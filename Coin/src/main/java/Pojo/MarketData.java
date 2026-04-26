package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketData {
    @JsonProperty("current_price")
    private Map<String, Double> currentPrice;

    @JsonProperty("market_cap")
    private Map<String, Double> marketCap;

    @JsonProperty("total_volume")
    private Map<String, Double> totalVolume;

    @JsonProperty("price_change_percentage_24h")
    private Double priceChangePercentage24h;
}
