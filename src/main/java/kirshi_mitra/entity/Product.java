package kirshi_mitra.entity;

import jakarta.persistence.*;
import kirshi_mitra.enums.ProductCategory;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private Integer quantityAvailable;
    private String unit;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private String location;
    private String imageUrl;
    private Boolean isAvailable = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private User farmer;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
