package ShopSimulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    private Comparator<Buyer> comparator = new Comparator<Buyer>() {
        @Override
        public int compare(Buyer b1, Buyer b2) {
            if (b1.boxOfficeTime() == b2.boxOfficeTime()) {
                return 0;
            }
            if (b1.boxOfficeTime() > b2.boxOfficeTime()) {
                return 1;
            }
            return -1;
        }
    };
    private CustomQueue boxOffice = new CustomQueue(comparator);
    private List<Buyer> buyers = new ArrayList<>();

    public void addBuyer(int[] data) throws Exception {
        try {
            if (!boxOffice.addElement(new Buyer().createNewBuyer(data))) {
                buyers.add(new Buyer().createNewBuyer(data));
            }
        } catch (Exception e) {
            throw new Exception("Buyer is incorrect");
        }
    }

    public List<Buyer> resultOfSimulation() {
        int size = boxOffice.getSize();
        int time = 0;
        for (int i = 0; i < size; i++) {
            try {
                Buyer buyer = boxOffice.poll();
                if (buyer.boxOfficeTime() >= time) {
                    buyer.setLeftTime(buyer.boxOfficeTime() + buyer.getN());
                } else {
                    buyer.setLeftTime(time + buyer.getN());
                }
                time = buyer.getLeftTime();
                buyers.add(buyer);
            } catch (Exception e) {
                break;
            }
        }
        return buyers;
    }

}
