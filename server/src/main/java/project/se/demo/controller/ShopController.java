package project.se.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.se.demo.entity.Customer;
import project.se.demo.entity.Item;
import project.se.demo.entity.Shop;
import project.se.demo.entity.ShopItem;
import project.se.demo.repository.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ShopController {
    @Autowired private final ShopRepository shopRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private CustomerRepository customerRepository;

    @Autowired
    ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/Shops")
    public Collection<Shop> Shop() {
        return shopRepository.findAll().stream()
                .collect(Collectors.toList());
    }
    @GetMapping("/Shop/{id}")
    public Optional<Shop> View(@PathVariable Long id) {
        Optional<Shop> S = shopRepository.findById(id);
        return S;
    }
    @PostMapping("/Shop/addItem/{idPlaylist}/{listCode}")
    public Shop addItem(@PathVariable long shopitemId,@PathVariable long itemId) {

        ShopItem shopitem = ShopItemRepository.findByShopitemId(shopitemId);
        Item item;

        for (                ) {
            item = itemRepository.findByItemId(itemId);
            ShopItem newshopItem = new ShopItem();
            newshopItem.setShop(shop);
            newshopItem.setPlaylistId(idPlaylist);
            pl_vRepository.save(newPL_V);
            playlist.getListVideo().add(newPL_V);
        }

        return  playlistRepository.save(playlist);

    }
    @PostMapping("addItem/{item}")
    public Shop item(@PathVariable Long itemId,@PathVariable String username, @PathVariable Long transportId) {
        Shop newShop = new Shop();
        Customer customer = customerRepository.findByUsername(username);
        Item item = itemRepository.findByItemId(itemId);

        newShop.setItemShop(item);
        newShop.setCustomerShop(customer);

        return shopRepository.save(newShop);
    }

    @PostMapping("/Shop/{itemId}/{username}/{transportId}")
    public Shop newShop(@PathVariable Long itemId,@PathVariable String username, @PathVariable Long transportId) {
        Shop newShop = new Shop();
        Customer customer = customerRepository.findByUsername(username);
        Item item = itemRepository.findByItemId(itemId);

        newShop.setItemShop(item);
        newShop.setCustomerShop(customer);

        return shopRepository.save(newShop);
    }


}
