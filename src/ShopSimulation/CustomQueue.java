package ShopSimulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomQueue {

    protected class Element {
        private Buyer buyer;
        private Element next;

        public Element(Buyer buyer, Element next) {
            this.buyer = buyer;
            this.next = next;
        }
    }

    private Element head;
    private Element tail;
    private int size = 0;

    Comparator<Buyer> comparator = new Comparator<Buyer>() {
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

    private boolean isEmpty() {
        return size == 0;
    }

    private void findPlace(Buyer buyer) {
        if (head.buyer.boxOfficeTime() > buyer.boxOfficeTime()) {
            head = new Element(buyer, head);
        } else {
            Element current = head;
            //int time = head.buyer.getN();
            while (current.next != null) {
                int t = comparator.compare(buyer, current.next.buyer);
                switch (t) {
                    case 0:
                        if (buyer.getN() >= current.next.buyer.getN()) {
                            current.next.next = new Element(buyer, current.next.next);
                        } else {
                            current.next = new Element(buyer, current.next);
                        }
                        break;
                    case -1:
                        current.next = new Element(buyer, current.next);
                        break;
                    default:
                        current = current.next;
                        break;
                }
            }
            if(current.next==null){
                tail.next=new Element(buyer, null);
                tail=tail.next;
            }
        }
    }

    private boolean isBuyerCorrect(Buyer buyer) {
        return buyer.getN() == 0;
    }

    public boolean addElement(Buyer buyer) {
        if (!isBuyerCorrect(buyer)) {
            buyer.setLeftTime(buyer.boxOfficeTime());
            return false;
        }
        if (isEmpty()) {
            head = tail = new Element(buyer, null);
        } else {
            findPlace(buyer);
        }
        size++;
        return true;
    }

    public List<Buyer> buyers(){
        Element current = head;
        head.buyer.setLeftTime(head.buyer.boxOfficeTime()+head.buyer.getN());
        int time = head.buyer.
        while (current.next!=null){
            current.next.buyer.setLeftTime(time);
            time+=
        }
    }

    //public void createQueue(ArrayList<Buyer> buyers){

}
