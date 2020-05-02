package ShopSimulation;

import java.util.List;

public class Shop {

    //private List<Buyer> buyers;
    private CustomQueue boxOffice;
    private boolean isShopOpen = true;


    public void addBuyer(int[] data)throws Exception{
        if(isShopOpen) {
            try {
                boxOffice.addElement(new Buyer().createNewBuyer(data));
            } catch (Exception e) {
                throw new Exception("Buyer is incorrect");
            }
        }else {
            throw new Exception("Shop is closed");
        }
    }

    public void closeShop(){
        isShopOpen=false;
    }

}
