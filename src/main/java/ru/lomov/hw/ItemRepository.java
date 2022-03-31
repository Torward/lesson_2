package ru.lomov.hw;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("itemRepository")
public class ItemRepository {

    private List<Item> items;

    @PostConstruct
    public void init(){
         items = new ArrayList<>(
                Arrays.asList(
                        new Item(1L, 120, "sugar"),
                        new Item(2L, 150, "milk"),
                        new Item(3L, 54, "bread"),
                        new Item(4L, 115, "pasta"),
                        new Item(5L, 540, "vodka")
                )
        );
    }

    public Item findById(Long id){
        return items.stream().filter(i -> i.getId().equals(id)).findFirst().get();
    }
    public List<Item> findAll(){
        return items;
    }

}
