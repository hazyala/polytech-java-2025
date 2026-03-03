package kiosk;

import java.util.*;

public class Cart {
    Map<String, Integer> item = new LinkedHashMap<>();
    Map<String, Integer> price = new HashMap<>();

    public void add(String name, int count, int p) {
        item.put(name, item.getOrDefault(name, 0) + count);
        price.put(name, p);
    }

    public void show() {
        if (item.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return;
        }

        for (String name : item.keySet()) {
            int count = item.get(name);
            int p = price.get(name);
            System.out.printf("%s - %d개 (총 %d원)\n", name, count, count * p);
        }

        System.out.println("총 합계: " + getTotal() + "원");
    }

    public int getTotal() {
        int total = 0;
        for (String name : item.keySet()) {
            total += item.get(name) * price.get(name);
        }
        return total;
    }

    public void clear() {
        item.clear();
        price.clear();
    }

    public boolean isEmpty() {
        return item.isEmpty();
    }
}
