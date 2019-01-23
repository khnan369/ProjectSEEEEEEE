package project.se.demo.repository;
import project.se.demo.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {

    static ShopItem findByShopitemId(long shopitemId) {
    }
}
