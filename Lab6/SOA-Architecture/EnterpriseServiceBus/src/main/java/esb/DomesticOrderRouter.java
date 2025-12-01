package esb;

import org.springframework.stereotype.Component;

@Component
public class DomesticOrderRouter {
    public String route(Order order){
        String destinationChannel = "normalshippingchannel";
        if(order.getAmount() > 175)
            destinationChannel = "nextdayshippingchannel";
        return destinationChannel;
    }
}
