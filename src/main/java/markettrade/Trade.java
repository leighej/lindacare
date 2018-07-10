package test.lindacare.markettrade;

import java.util.UUID;
import com.fasterxml.uuid.Generators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds an individual trade
 */
public class Trade {
    private static final Logger logger = LoggerFactory.getLogger(Trade.class);

    private final String userId;
    private final String currencyFrom;
    private final String currencyTo;
    private final double amountSell;
    private final double amountBuy;
    private final double rate;
    private final String timePlaced;    
    private final String originatingCountry;
    private final UUID uuid;
    

    public Trade(String userId, String currencyFrom, String currencyTo, double amountSell, double amountBuy, 
            double rate, String timePlaced, String originatingCountry, UUID uuid ) {
        this.userId = userId;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amountSell = amountSell;
        this.amountBuy = amountBuy;
        this.rate = rate;
        this.timePlaced = timePlaced;
        this.originatingCountry = originatingCountry;
        // Add a unique identifier so that we can later retrieve this trade
        this.uuid = Generators.timeBasedGenerator().generate();
    }

    public String getUserId() {
        return userId;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public double getAmountSell() {
        return amountSell;
    }

    public double getAmountBuy() {
        return amountBuy;
    }

    public double getRate() {
        return rate;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public UUID getUuid() {
        return uuid;
    }
}