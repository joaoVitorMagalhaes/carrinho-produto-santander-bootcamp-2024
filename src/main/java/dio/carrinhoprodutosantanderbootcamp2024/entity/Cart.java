package dio.carrinhoprodutosantanderbootcamp2024.entity;

import dio.carrinhoprodutosantanderbootcamp2024.enums.CartStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity(name = "tb_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(precision = 4, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    public Cart() {
        this.createdAt = LocalDateTime.now();
        this.total = BigDecimal.ZERO;
        this.status = CartStatus.OPEN;
    }
}
