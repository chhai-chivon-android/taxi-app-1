package com.gosiewski.taxiapp.controller;

import com.gosiewski.taxiapp.model.Order;
import com.gosiewski.taxiapp.model.OrderDto;
import com.gosiewski.taxiapp.repository.OrdersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
public class OrdersController {
    private final OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @GetMapping(value = "/orders")
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity<Collection<Order>> getOrdersPerUser(Principal principal) {
        Collection<Order> userOrders = ordersRepository.findByUserAndFinished(principal.getName(), false);

        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }

    @PostMapping(value = "/orders/{id}")
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity finishOrder(Principal principal, @PathVariable("id") Long orderId) {
        Order orderToFinish = ordersRepository.findOne(orderId);

        if (orderToFinish != null) {
            if (orderToFinish.getUser().equals(principal.getName())) {
                orderToFinish.setFinished(true);
                ordersRepository.save(orderToFinish);
                return new ResponseEntity(HttpStatus.OK);
            } else
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/orders/{id}")
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity deleteOrder(Principal principal, @PathVariable("id") Long orderId) {
        Order orderToDelete = ordersRepository.findOne(orderId);

        if (orderToDelete != null) {
            if (orderToDelete.getUser().equals(principal.getName())) {
                ordersRepository.delete(orderId);
                return new ResponseEntity(HttpStatus.OK);
            }

            else
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/orders")
    @PreAuthorize("hasAuthority('CLIENT')")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto orderDto, Principal principal) {
        Order createdOrder = ordersRepository.save(new Order(principal.getName(), System.currentTimeMillis(),
                orderDto.lattitude, orderDto.langtitude));

       return new ResponseEntity<>(createdOrder, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/unaccepted")
    @PreAuthorize("hasAuthority('DRIVER')")
    public ResponseEntity<Collection<Order>> getUnacceptedOrders() {
        Collection<Order> unacceptedOrders = ordersRepository.findByFinishedAndAcceptedBy(false, "");

        return new ResponseEntity<>(unacceptedOrders, HttpStatus.OK);
    }

    @GetMapping(value = "/orders/accepted")
    @PreAuthorize("hasAuthority('DRIVER')")
    public ResponseEntity<Collection<Order>> getMyAcceptedOrders(Principal principal) {
        Collection<Order> acceptedOrders = ordersRepository.findByFinishedAndAcceptedBy(false,
                principal.getName());

        return new ResponseEntity<>(acceptedOrders, HttpStatus.OK);
    }

    @PostMapping(value = "/orders/{id}/accept")
    @PreAuthorize("hasAuthority('DRIVER')")
    public ResponseEntity acceptOrder(Principal principal, @PathVariable("id") Long orderId) {
        Order orderToAccept = ordersRepository.findOne(orderId);

        if (orderToAccept == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else if (!orderToAccept.getAcceptedBy().isEmpty())
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        else {
            orderToAccept.setAcceptedBy(principal.getName());
            ordersRepository.save(orderToAccept);

            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
