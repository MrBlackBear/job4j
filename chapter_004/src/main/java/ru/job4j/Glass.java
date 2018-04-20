package ru.job4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Glass {
    /**
     * Name of glass
     */
    String name;

    /**
     * Constructor
     *
     * @param name name
     */
    public Glass(String name) {
        this.name = name;
    }

    public void whatToDo(Stock stock) {
        if (stock.type) {
            add(stock);
        } else {
            delete(stock);
        }
    }

    private void add(Stock stock) {
        if (stock.action) {
            for (Stock st : sell) {
                if (st.price <= stock.price) {
                    if (st.volume >= stock.volume) {
                        st.volume -= stock.volume;
                        if (st.volume == 0) {
                            sell.remove(st);
                            return;
                        }
                    } else {
                        stock.volume -= st.volume;
                        sell.remove(st);
                        buy.add(stock);
                        return;
                    }
                }
            }
            buy.add(stock);
            Collections.sort(buy);
        } else {
            for (Stock st : buy) {
                if (st.price >= stock.price) {
                    if (st.volume >= stock.volume) {
                        st.volume -= stock.volume;
                        if (st.volume == 0) {
                            buy.remove(st);
                            return;
                        }
                    } else {
                        stock.volume -= st.volume;
                        buy.remove(st);
                        sell.add(stock);
                        return;
                    }
                }
            }
            sell.add(stock);
            Collections.sort(sell);
        }

    }

    private void delete(Stock stock) {
        if (stock.action) {
            for (Stock s : buy) {
                if (stock.id.equals(s.id)) {
                    buy.remove(s);
                }
            }
            Collections.sort(buy);
        } else {
            for (Stock s : sell) {
                if (stock.id.equals(s.id)) {
                    sell.remove(s);
                }
            }
            Collections.sort(sell);
        }
    }

    /**
     * Stocks to buy
     */
    private List<Stock> buy = new LinkedList<>();

    /**
     * Stocks to sell
     */
    private List<Stock> sell = new LinkedList<>();

    public List<Stock> getBuy() {
        return buy;
    }

    public List<Stock> getSell() {
        return sell;
    }
}
