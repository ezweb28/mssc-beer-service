package skim.springframework.msscbeerservice.services.order;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import skim.sfg.brewery.model.events.ValidateOrderRequest;
import skim.sfg.brewery.model.events.ValidateOrderResult;
import skim.springframework.msscbeerservice.config.JmsConfig;

@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator validator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest) {
        Boolean isValid = validator.validateOrder(validateOrderRequest.getBeerOrder());

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                    .isValid(isValid)
                    .orderId(validateOrderRequest.getBeerOrder().getId())
                    .build());
    }
}
