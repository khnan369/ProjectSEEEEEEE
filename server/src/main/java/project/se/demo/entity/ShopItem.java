package project.se.demo.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ShopItem {
    @Id
    @SequenceGenerator(name="shopitem_seq",sequenceName="shopitem_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="shopitem_seq")
    @Column(name="ShopItem_ID")
    private @NonNull  Long shopitemId;

    private Long shopId;
    private int number;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Item.class)
    @JoinColumn(name = "IT_ID", insertable = true)
    private  Item item;

}
