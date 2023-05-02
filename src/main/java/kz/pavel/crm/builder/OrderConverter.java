package kz.pavel.crm.builder;

import kz.pavel.crm.dto.OrderDTO;
import kz.pavel.crm.dto.OrderRequestDTO;
import kz.pavel.crm.entity.Order;

public class OrderConverter {
    public static OrderDTO toOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setCheckId(order.getCheck().getId());
        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setProducts(order.getProducts());

        return orderDTO;
    }
}
