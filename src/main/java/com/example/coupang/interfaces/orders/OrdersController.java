package com.example.coupang.interfaces.orders;

import com.example.coupang.application.OrdersFacade;
import com.example.coupang.common.Util;
import com.example.coupang.interfaces.payment.PaymentDto;
import com.example.coupang.interfaces.payment.PaymentDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders/v1")
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersDtoMapper ordersDtoMapper;
    private final PaymentDtoMapper paymentDtoMapper;
    private final OrdersFacade ordersFacade;


    @GetMapping("/{orderToken}")
    public String goToCheckout(@PathVariable String orderToken, Model model) {
        var order = ordersFacade.getOrder(orderToken);
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping
    public @ResponseBody OrdersDto.RegistOrderResponse registOrder(@RequestBody OrdersDto.RegistOrderRequest request, Model model) {
        var ordersDetailsCommand = request.getOrdersDetails().stream()
                .map(ordersDtoMapper::of)
                .toList();
        var command = ordersDtoMapper.of(request, Util.getUid().orElseThrow(), ordersDetailsCommand);
        var orders = ordersFacade.registOrder(command);
        var result = ordersDtoMapper.of(orders);
        model.addAttribute("order", result);
        return result;
    }

    @PostMapping("/checkout")
    public @ResponseBody OrdersDto.CheckoutOrderResponse checkoutOrder(@RequestBody OrdersDto.CheckoutOrderRequest request) {
        var checkoutOrder = ordersDtoMapper.toCheckoutOrders(request);
        var paymentRequest = paymentDtoMapper.of(request);
        var orders = ordersFacade.checkoutOrder(checkoutOrder, paymentRequest);
        return ordersDtoMapper.toCheckOrderResponse(orders);
    }

    @GetMapping("/complete")
    public String goToOrderComplete() {
        return "orderComplete";
    }

}
