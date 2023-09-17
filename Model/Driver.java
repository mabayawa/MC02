package mc02final.mc02.Model;

import java.util.ArrayList;

public class Driver{
    private ArrayList<ItemSlot> slotList;
    private ArrayList<Denomination> denomList;
    private ArrayList<SpecialItemSlot> specialItemList;

    public Driver() {
        this.slotList = new ArrayList<ItemSlot>();
        initSlotList();
        this.denomList = new ArrayList<Denomination>();
        initDenom();
        this.specialItemList = new ArrayList<SpecialItemSlot>();
        initSpecialItem();
    }
    
    private void initSpecialItem(){
        ArrayList<Item> sojuBomb = new ArrayList<Item>();
        sojuBomb.add(this.getSlotList().get(1).getItem());
        sojuBomb.add(this.getSlotList().get(8).getItem());
        this.specialItemList.add(new SpecialItemSlot("Soju Bomb", 103,150,0, sojuBomb,"AA1"));
        
        ArrayList<Item> ginTonic = new ArrayList<Item>();
        ginTonic.add(this.getSlotList().get(3).getItem());
        ginTonic.add(this.getSlotList().get(9).getItem());
        this.specialItemList.add(new SpecialItemSlot("Gin and Tonic", 103,150,1000, ginTonic,"AA2"));
        
        ArrayList<Item> jackCoke = new ArrayList<Item>();
        jackCoke.add(this.getSlotList().get(2).getItem());
        jackCoke.add(this.getSlotList().get(11).getItem());
        this.specialItemList.add(new SpecialItemSlot("Jack and Coke", 270, 300,500, jackCoke,"AA3"));
        
        ArrayList<Item> screwDriver = new ArrayList<Item>();
        screwDriver.add(this.getSlotList().get(4).getItem());
        screwDriver.add(this.getSlotList().get(10).getItem());
        this.specialItemList.add(new SpecialItemSlot("Scredriver",164, 400,500,screwDriver,"AA4"));
    }
    
    public ArrayList<SpecialItemSlot> getSpecialSlotList(){
        return this.specialItemList;
    }
    
    private void initSlotList() {
        this.slotList.add(new ItemSlot("Red Wine", 85, 430, 15, "A1"));
        this.slotList.add(new ItemSlot("Beer", 43, 45, 50, "A2"));
        this.slotList.add(new ItemSlot("Whiskey", 250, 2000, 5, "A3"));
        this.slotList.add(new ItemSlot("Gin", 263, 730, 30, "B1"));
        this.slotList.add(new ItemSlot("Vodka", 231, 800, 30, "B2"));
        this.slotList.add(new ItemSlot("Rum", 231, 790, 55, "B3"));
        this.slotList.add(new ItemSlot("Tequila", 97, 590, 65, "C1"));
        this.slotList.add(new ItemSlot("Brandy", 230, 250, 80, "C2"));
        this.slotList.add(new ItemSlot("Soju", 60, 100, 0, "C3"));
        this.slotList.add(new ItemSlot("Tonic Water", 42, 100, 10000, "D1"));
        this.slotList.add(new ItemSlot("Orange Juice", 45, 75, 10000, "D2"));
        this.slotList.add(new ItemSlot("Cola", 150, 75, 5000, "D3"));
    }

    public ArrayList<ItemSlot> getSlotList() {
        return this.slotList;
    }

    private void initDenom() {
        this.denomList.add(new Denomination(1, 100));
        this.denomList.add(new Denomination(5, 100));
        this.denomList.add(new Denomination(10, 100));
        this.denomList.add(new Denomination(20, 100));
        this.denomList.add(new Denomination(50, 100));
        this.denomList.add(new Denomination(100, 100));
        this.denomList.add(new Denomination(200, 100));
        this.denomList.add(new Denomination(500, 100));
        this.denomList.add(new Denomination(1000, 100));
    }

    public ArrayList<Denomination> getDenomList() {
        return this.denomList;
    }
}
