package ShopSimulation;

public class Buyer {

    private int S; //Время прихода по условию
    private int T; //Время выбора товаров по условию
    private int N; //Количество товаров по условию
    private int leftTime;

    public int getS() {
        return S;
    }

    public int getN() {
        return N;
    }

    public int getT() {
        return T;
    }

    public void setLeftTime(int leftTime) {
        if(leftTime>=boxOfficeTime()) {
            this.leftTime = leftTime;
        }
    }

    public int getLeftTime() {
        return leftTime;
    }

    public int boxOfficeTime(){
        return S+T;
    }

    public Buyer createNewBuyer(int[] data) throws Exception {
        if (isBuyerDataCorrect(data)) {
            Buyer newBuyer = new Buyer();
            newBuyer.S=data[0];
            newBuyer.T=data[1];
            newBuyer.N=data[2];
            return newBuyer;
        } else {
            throw new Exception("Данные покупателя некорректны");
        }
    }

    private boolean isBuyerDataCorrect(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
