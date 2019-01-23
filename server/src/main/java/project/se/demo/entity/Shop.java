package project.se.demo.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Shop {
    @Id
    @SequenceGenerator(name="shop_seq",sequenceName="shop_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shop_seq")
    @Column(name="Shop_ID")
    private @NonNull Long shopId;

    private String subdist;
    private String postcode;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CS_ID", insertable = true)
    private Customer customerShop;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Collection<ShopItem> item;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = District.class)
    @JoinColumn(name = "DT_ID", insertable = true)
    private District districtShop;


}
