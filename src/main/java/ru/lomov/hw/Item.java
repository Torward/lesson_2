package ru.lomov.hw;

public class Item {
   private long id;
   private int price;
   private String itemName;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   @Override
   public String toString() {
      return "Item{" +
              "id=" + id +
              ", price=" + price +
              ", itemName='" + itemName + '\'' +
              '}';
   }
}
