package q3;

class Food {
    String name;
    int basePrice;

    public void setname(String name) {
        this.name = name;
    }
    public void setbaseprice(int basePrice) {
        if (basePrice >= 1000000) {
            throw new IllegalArgumentException("Invalid Base Price");
        }
        this.basePrice = basePrice;
         
    }
    public int calcPrice() {
        return basePrice + 5000; //labor cost
    }
    public void getInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + calcPrice());
    }
}

class RegularMenu extends Food {

    @Override
    public int calcPrice() {
        return this.basePrice + 5000 + 10000;

    }
}

class SpecialMenu extends Food {

    @Override
    public int calcPrice() {
        return this.basePrice + 5000 + 20000;
    }
}

public class q3 {
    public static void main(String[] args) {
        Food satu = new Food();
        satu.setname("Beef Rendang");
        satu.setbaseprice(15000);

        Food dua = new RegularMenu();
        dua.setname("Chicken Ramen");
        dua.setbaseprice(20000);

        Food tiga = new SpecialMenu();
        tiga.setname("Fiery Fried Chicken");
        tiga.setbaseprice(80000);

        satu.getInfo();
        dua.getInfo();
        tiga.getInfo();
    }
}
