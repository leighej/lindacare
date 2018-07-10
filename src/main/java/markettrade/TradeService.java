package test.lindacare.markettrade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Component;

import test.lindacare.markettrade.Trade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A service to handle the trades 
 */
@Component
public class TradeService {
    private static final Logger logger = LoggerFactory.getLogger(TradeService.class);

    private List<Trade> trades = new ArrayList<Trade>();
    private Map<String, List<Trade>> userTrades = new HashMap<String, List<Trade>>();


    /**
     * Adds a trade to list of existing trades
     */
    public UUID addTrade(Trade trade) {
        trades.add(trade);
        String userId = trade.getUserId();
        if (this.userTrades.containsKey(userId)) {
            List<Trade> userExistingTrades = this.userTrades.get(userId);
            userExistingTrades.add(trade);
        } else {
            List<Trade> newUserTrades = new ArrayList<Trade>();
            newUserTrades.add(trade);
            this.userTrades.put(userId, newUserTrades);
        }
        logger.info("Trade added!");        
        return trade.getUuid();
    }

    /**
     * Gets a trade by it's uuid
     */
    public Trade getTradeByUUID(UUID uuid) {
        Trade requestedTrade = null;
        for (int i =0; i < this.trades.size(); i++) {
            if (this.trades.get(i).getUuid().equals(uuid)) {
                requestedTrade = this.trades.get(i);
                logger.info("Trade found with UUID :- " + uuid);
                break;
            }
        }
        if (requestedTrade == null) {
            logger.info("NO Trade was found with UUID :- " + uuid);
        }

        return requestedTrade;
    }

    /**
     * Return the unique list of userId's that have traded
     */
    public List<String> getUserThatHaveTraded() {
        List<String> users = new ArrayList<String>(this.userTrades.keySet());
        return users;
    }

    /**
     * Gets a list of trades done by a uesr with userID specified
     */
    public List<Trade> getTradesByUserId(String userId) {
        List<Trade> requestedTrades = new ArrayList<Trade>();

        if (this.userTrades.containsKey(userId)) {
            requestedTrades = this.userTrades.get(userId);
        }

        return requestedTrades;
    }

    /**
     * Returns all the trades that have been submitted
     */
    public List<Trade> getTrades() {
        return this.trades;
    }

}