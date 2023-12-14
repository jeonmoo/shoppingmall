package com.example.coupang.service.orders;

import com.example.coupang.domain.orders.Orders;
import com.example.coupang.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;

    public Orders registOrder(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders getOrder(String orderToken) {
        return ordersRepository.findOrderByOrderToken(orderToken);
    }

    @Override
    public Orders checkout(Orders orders, String receiverName, String receiverTel, String receiverAddr, String receiverAddrDetail, String deliveryMsg) {
        return orders.checkout(receiverName, receiverTel, receiverAddr, receiverAddrDetail, deliveryMsg);
    }

}
