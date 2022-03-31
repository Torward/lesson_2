package ru.lomov.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("cart")
@Scope("prototype")
public class Cart {
    @Autowired
    ItemRepository itemRepository = new ItemRepository();

    private final List<Item> itemList = new ArrayList<>();

    public void putById(Long id) {
        itemList.add(itemRepository.findById(id));
    }

    public void removeById(Long id) {
        itemList.remove(itemRepository.findById(id));
    }

    public List<Item> info() {
        return itemList;
    }

}
