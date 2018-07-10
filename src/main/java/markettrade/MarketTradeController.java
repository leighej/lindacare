package test.lindacare.markettrade;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MarketTradeController {

    @Autowired
	private TradeService tradeService;

    private List<Trade> testTrades = new ArrayList<Trade>();

    @PostMapping("/trade")
    public UUID add(@RequestBody Trade trade) {
        
        UUID uuid = tradeService.addTrade(trade);

        return uuid;
    }

    @GetMapping("/trades")
	public List<Trade> getTrades() {
        return tradeService.getTrades();
    }    

    @GetMapping("/trade/{uuid}")
    public ResponseEntity getTradeById(@PathVariable UUID uuid ) {
       
        Trade requestedTrade = tradeService.getTradeByUUID(uuid);
       
        if (requestedTrade != null ) {
            return new ResponseEntity(requestedTrade, HttpStatus.OK);
        } else {
            return new ResponseEntity("Trade not found for UUID " + uuid, HttpStatus.NOT_FOUND);
        }
    }
    

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        List<String> users = tradeService.getUserThatHaveTraded();

        if (users.size() > 0) {
            return new ResponseEntity(users, HttpStatus.OK);
        } else {
            return new ResponseEntity("No users have traded!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/trades/{userId}")
    public ResponseEntity getTradesByUser(@PathVariable String userId ) {

        List<Trade> requestedTrades = tradeService.getTradesByUserId(userId);
                
        if (requestedTrades.size() > 0) {
            return new ResponseEntity(requestedTrades, HttpStatus.OK);
        } else {
            return new ResponseEntity("No trades not found for userId " + userId, HttpStatus.NOT_FOUND);
        }
    }

}
