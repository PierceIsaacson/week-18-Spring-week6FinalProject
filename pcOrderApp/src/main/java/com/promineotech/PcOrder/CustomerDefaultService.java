package com.promineotech.PcOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDefaultService extends JpaRepository<Customer, Integer> {
}
