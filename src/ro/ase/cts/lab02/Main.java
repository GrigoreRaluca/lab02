package ro.ase.cts.lab02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        OShop o = new OShop("Emag", "logo.jpg", new ArrayList<Prod>());

        Prod p1 = new Prod("Laptop", 3200.5, 1,1, 1123, "");
        Prod p2 = new Prod("Frigider", 207.95, 1,2, 1245, "");

        Prod p3 = new Prod(p1);

        p3.setQty(5);
        p3.setProdName("Paine");

        o.modifyProductsList(1,p1);
        o.modifyProductsList(1,p2);

        o.modifyProductsList(2, p1);
        System.out.println(p1.equals(p2));
    }
}

class OShop {
    //IN CLASA ASTA SE PUNE MECANISMUL PRIN CARE RETINEM CATE PRODUSE MAI SUNT IN STOC
    //
    private String onlineShopName;
    private String i;
    private ArrayList<Prod> products;

    OShop(String name, String img, ArrayList<Prod> products)
    {
        this.products = new ArrayList<Prod>();
        this.i = img;
        this.onlineShopName = name;
    }

    public void modifyProductsList(int what, Prod p)
    {
        if(what == 1)
        {
            this.products.add(p);
        }
        else
            this.products.remove(p);
    }

    public String getOnlineShopName() {
        return onlineShopName;
    }

    public void setOnlineShopName(String onlineShopName) {
        this.onlineShopName = onlineShopName;
    }

    public String getI() {
        return i;
    }

    public void setImg(String img) {
        this.i = img;
    }
}

class Product
{
    private int id;
    private String name;
    private double price;
    private Category category;
    //SCOATE VARIABILA CANTITATE
    private int quantiy;
    private String details; // ex.: processor, memory, power, volume (for refrigerators etc)
//trebuie VALIDARI!!!!!!!!!!!!!
    public Product(int id, String name, double price, Category category, int quantiy, String details)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.quantiy=quantiy;
        this.details=details;

    }

    //PRODUSUL NOU SE PUNE SEPARAT
    public Product(Product product)
    {
        this.id=product.id;
        this.name=product.name;
        this.price=product.price;
        this.category=product.category;
        this.quantiy=product.quantiy;
        this.details=product.details;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double productPrice) {
        this.price = productPrice;
    }

    public String getProdName() {
        return name;
    }

    public void setProdName(String productName) {
        this.name = productName;
    }



    public boolean equals(Product product)
    {
        if(product.id != this.id)
            return false;
        if(!product.name.equals(this.name))
            return false;
        if(product.price != this.price)
            return false;
        if(product.category != this.category)
            return false;

        return true;
    }
   public void raiseProcentProductPrice(double procent)
   {
       if(procent>=0&&procent<=1)
       {
           this.price+=this.price*procent;
       }
   }
   public void reductProcentProductPrice(double procent)
   {
       if(procent>=0&&procent<=1)
       {
           this.price-=this.price*procent;
       }
   }
   public void raiseValueProductPrice(double value)
   {
       this.price+=this.price*value/100;
   }
    public void reductValueProductPrice(double value)
    {
        this.price-=this.price*value/100;
    }

    public void modify(boolean flag, double val)
    {
        if(flag)
            this.productPrice+=this.productPrice*val;
        if(!flag)
            this.productPrice-=this.productPrice*val/100;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantity(int quantity) {
        this.quantiy = quantity;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int productId) {
        this.id = productId;
    }

    public String getDetails() {
        return details;
    }

    public void setProductDetails(String details) {
        this.details = details;
    }
}
//trebuie o clasa pentru order si o clasa pentru cart
//in clasa user trebuie un obiect de tip cart
class User
{
    private String usn;
    private String userId;
    //order(comanda)
    private ArrayList<Order> o;
    //cart(cos de cumparaturi)
    private Cart cart;

    public User(String usn, String userId)
    {
        this.usn = usn;
        this.userId = userId;
        o=new ArrayList<Order>();
        c=new ArrayList<Order>();
    }
   //adauga un obiect in cos si plaseaza comanda

    public void addO1(Order o)
    {
        this.o.add(o);
    }

    public void addO2(Order o)
    {
        this.c.add(o);
    }
}

class Order
{
    private ArrayList<Prod> l;
    private String addr;

    public Order()
    {
        l = new ArrayList<Prod>();
    }
    public void add(Prod p)
    {
        if(l.size() > 99)
            return;

        l.add(p);
    }

    public void remove(Prod p)
    {
        l.remove(p);
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

class InventoryP
{
    private Prod p;
    private int q;

    public InventoryP(Prod p, int q)
    {
        this.p = new Prod(p);
        this.q = q;
    }
    public Prod getP() {
        return p;
    }

    public void setP(Prod p) {
        this.p = p;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }
}


