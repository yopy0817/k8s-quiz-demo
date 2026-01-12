package com.example.demo.component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DEMO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Demo {

    @Id
    private String id;
    @Column(length = 50)
    private String ipAddress;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime timestamp;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

}
