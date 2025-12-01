package esb;

import org.springframework.stereotype.Component;

@Component
public class OrderRouter {
    public String route(Order order){
        String destinationChannel = null;
        if(order.getOrderType().equals("international"))
            destinationChannel = "internationalshippingchannel";
        else if(order.getOrderType().equals("domestic"))
            destinationChannel = "domesticshippingchannel";
        return destinationChannel;
    }
}
