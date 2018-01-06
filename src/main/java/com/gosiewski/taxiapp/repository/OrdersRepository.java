package com.gosiewski.taxiapp.repository;

import com.gosiewski.taxiapp.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface OrdersRepository extends CrudRepository<Order, Long> {
    Collection<Order> findByUserAndFinished(String username, boolean finished);
    Collection<Order> findByFinishedAndAcceptedBy(boolean finished, String acceptedBy);
}
