package kiosk;

import java.util.*;

public abstract class PetProduct {
    protected List<String> name = new ArrayList<>();
    protected List<String> detail = new ArrayList<>();
    protected List<Integer> price = new ArrayList<>();

    public abstract void setList();

    public void showList() {
        for (int i = 0; i < name.size(); i++) {
            System.out.printf("%d. %s - %d원\n   → %s\n", i + 1, name.get(i), price.get(i), detail.get(i));
        }
    }

    public String getName(int index) {
        return name.get(index);
    }

    public int getPrice(int index) {
        return price.get(index);
    }

    public String getDetail(int index) {
        return detail.get(index);
    }

    public int getSize() {
        return name.size();
    }
}


