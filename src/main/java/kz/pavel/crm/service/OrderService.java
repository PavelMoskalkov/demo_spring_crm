package kz.pavel.crm.service;

import kz.pavel.crm.entity.Order;
import kz.pavel.crm.entity.Product;
import kz.pavel.crm.repository.OrderRepository;
import kz.pavel.crm.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(EntityNotFoundException::new);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public void addProductsToOrder(Order order, List<Product> products) {
        order.setProducts(products);
        this.saveOrder(order);
    }
}
