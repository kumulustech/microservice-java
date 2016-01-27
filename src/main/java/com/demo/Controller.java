package com.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/items")
    public List<Item> items() {
        List<Item> items = new ArrayList<Item>();
        Item item1 = new Item();
        item1.setName("a");
        items.add(item1);

        Item item2 = new Item();
        item2.setName("b");
        items.add(item2);

        Item item3 = new Item();
        item3.setName("c");
        items.add(item3);

        return items;
    }

}
