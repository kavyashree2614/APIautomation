package Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinResponse {

    private String id;
    private String symbol;
    private String name;
    private String webSlug;

    @JsonProperty("market_data")
    private MarketData marketData;

    @JsonProperty("links")
    private Links links;

}
