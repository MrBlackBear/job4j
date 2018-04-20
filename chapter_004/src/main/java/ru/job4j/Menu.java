package ru.job4j;

public class Menu {
    void show(Glass glass) {
        int price = 0;
        int volume = 0;
        System.out.printf("%s   %s", "Покупка", "Цена");
        for (Stock st : glass.getBuy()) {
            if (price == 0) {
                price = st.price;
                volume = st.volume;
                continue;
            }
            if (st.price == price) {
                volume += st.volume;
            } else {
                System.out.printf("\n%s        %s", volume, price);
                price = st.price;
                volume = st.volume;
            }
        }
        System.out.printf("\n%s        %s", volume, price);
        price = 0;
        volume = 0;
        System.out.printf("\n%s   %s", "Продажа", "Цена");
        for (Stock st : glass.getSell()) {
            if (price == 0) {
                price = st.price;
                volume = st.volume;
                continue;
            }
            if (st.price == price) {
                volume += st.volume;
            } else {
                System.out.printf("\n%s        %s", volume, price);
                price = st.price;
                volume = st.volume;
            }
        }
        System.out.printf("\n%s        %s", volume, price);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Glass first = new Glass("1");
        Glass second = new Glass("2");
        first.whatToDo(new Stock("1", true, true, 44, 11));
        first.whatToDo(new Stock("1", true, true, 43, 11));
        first.whatToDo(new Stock("1", true, true, 41, 11));
        first.whatToDo(new Stock("1", true, false, 46, 11));
        first.whatToDo(new Stock("1", true, false, 47, 11));
        first.whatToDo(new Stock("1", true, false, 49, 11));
        menu.show(first);
    }
}
