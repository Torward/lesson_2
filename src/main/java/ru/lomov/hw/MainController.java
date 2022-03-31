package ru.lomov.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class MainController {
    @Autowired
    private ItemRepository itemRepository = new ItemRepository();
    @Autowired
    private Cart cart = new Cart();
    private boolean isOut = false;

    @PostConstruct
    public void init() {
        while (!isOut) {
            getItemList();
            infoCart();
            chooseAction();
        }
    }

    public void getItemList() {
        System.out.println(itemRepository.findAll());
    }

    public void infoCart() {
        if (cart.info().isEmpty()) {
            System.out.println("Ваша корзина пуста.");
        } else {
            System.out.println("В вашей корзине находятся следующие продукты: "+cart.info().toString());
        }

    }

    public void putInCart(Long id) {
        cart.putById(id);
        infoCart();
    }

    public void removeFromCart(Long id) {
        cart.removeById(id);
        infoCart();
    }

    public long chooseItem() {
        System.out.println("Выберите id продукта.");
        Scanner in = new Scanner(System.in);
        return in.nextLong();
    }

    public void chooseAction() {
        System.out.println("Выберете действие: 1 - положить продукт в корзину; 2 - удалить продукт из корзины; 3 - выйти;");
        Scanner in = new Scanner(System.in);
        int var = in.nextInt();
        if (var == 1) {
            putInCart(chooseItem());
        } else if (var == 2) {
            if (cart.info() == null) {
                System.out.println("Нельзя отнять от пустоты.");
            }  else {
                removeFromCart(chooseItem());
            }
        } else if (var == 3){
            isOut = true;
        }else {
            System.out.println("Выберите из предложенных вариантов.");
        }
    }

}
