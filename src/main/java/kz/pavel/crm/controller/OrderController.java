package kz.pavel.crm.controller;

import kz.pavel.crm.dto.OrderDTO;
import kz.pavel.crm.dto.OrderRequestDTO;
import kz.pavel.crm.dto.ProductsToOrderRequestDTO;
import kz.pavel.crm.entity.Order;
import kz.pavel.crm.entity.Product;
import kz.pavel.crm.service.CheckService;
import kz.pavel.crm.service.CustomerService;
import kz.pavel.crm.service.OrderService;
import kz.pavel.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static kz.pavel.crm.builder.OrderConverter.toOrderDTO;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    private final ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        return toOrderDTO(orderService.getOrder(id));
    }

    @PostMapping
    public void saveOrder(@RequestBody OrderRequestDTO request) {
        Order order = new Order();

        order.setCustomer(customerService.getCustomer(request.getCustomerId()));

        orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping
    public void updateOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Order existingOrder = orderService.getOrder(orderRequestDTO.getId());

        existingOrder.setCustomer(customerService.getCustomer(orderRequestDTO.getCustomerId()));

        orderService.saveOrder(existingOrder);
    }

    @PutMapping("/add-products")
    public void setProductsToOrder(@RequestBody ProductsToOrderRequestDTO request) {

        Order order = orderService.getOrder(request.getId());

        List<Long> orderProducts = new ArrayList<>(order.getProducts().stream().map(Product::getId).toList());
        if (!orderProducts.isEmpty()) {

            for (Long productId : orderProducts) {
                Product product = productService.getProduct(productId);
                int currentStockBalance = product.getStockBalance();
                product.setStockBalance(currentStockBalance + 1);
            }

            List<Long> products = new ArrayList<>(request.getProducts());
            List<Product> resultProducts = new ArrayList<>();
            for (Long productId : products) {
                Product product = productService.getProduct(productId);
                int currentStockBalance = product.getStockBalance();
                product.setStockBalance(currentStockBalance - 1);

                resultProducts.add(product);
            }
            orderService.addProductsToOrder(order, resultProducts);
        } else {
            List<Product> products = new ArrayList<>();

            for (Long productId : request.getProducts()) {
                Product product = productService.getProduct(productId);

                int currentStockBalance = product.getStockBalance();
                product.setStockBalance(currentStockBalance - 1);

                products.add(product);
            }
            orderService.addProductsToOrder(order, products);
        }
    }
}


//        List<Long> p2 = new ArrayList<>(request.getProducts());


//        List<Long> removedProduct = new ArrayList<>(p1); // создаем копию первого списка
//        removedProduct.removeAll(p2);  // удаляем все элементы второго списка из копии первого списка
//
//        List<Long> addedProduct = new ArrayList<>(p2); // создаем копию второго списка
//        addedProduct.removeAll(p1); // удаляем все элементы первого списка из копии второго списка
