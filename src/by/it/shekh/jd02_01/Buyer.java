package by.it.shekh.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean isPensioner = false;
    private Map<String, Integer> goodsInBasket;

    public Buyer(int number) {
        super("Покупатель №" + number);
        if (number % 4 == 0)
            isPensioner = true;

    }

    private boolean isPensioner() {
        return isPensioner;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }


    @Override
    public void takeBasket() {
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(200, 400);
        else
            timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        goodsInBasket = new HashMap<String, Integer>();
        System.out.println(this + " взял корзину");

    }

    @Override
    public void chooseGoods() {
        String goodName;
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(1000, 4000);
        else
            timeout = Util.rnd(500, 2000);
        for (int i = 0; i < Util.rnd(1, 5); i++) {
            Util.sleep(timeout);
            goodName = Goods.getRndProduct();
            putGoodsToBasket(goodName);
            System.out.println(goodName + " в корзине " + this);
        }
        System.out.println(this + " выбрал товары");
    }


    @Override
    public void putGoodsToBasket(String pr) {
        int timeout;
        if (isPensioner())
            timeout = Util.rnd(200, 400);
        else
            timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        if (!goodsInBasket.containsKey(pr))
            goodsInBasket.put(pr, 1);
        else
            goodsInBasket.put(pr, goodsInBasket.get(pr + 1));
        System.out.println(this + " положил товары в корзину");
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }
}
