package com.example.demo.component;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoJpaRepository extends JpaRepository<Demo, String> {
}
