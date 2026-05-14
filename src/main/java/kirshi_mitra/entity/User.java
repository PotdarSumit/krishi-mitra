package kirshi_mitra.entity;


import jakarta.persistence.*;
import kirshi_mitra.enums.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "farmer")
    private List<Product> products;

/*    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;
    */
    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public  void preUpdated(){
        updatedAt = LocalDateTime.now();
    }
}
