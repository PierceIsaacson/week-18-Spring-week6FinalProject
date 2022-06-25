package com.promineotech.PcOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDefaultService extends JpaRepository<Order, Integer> {
}
