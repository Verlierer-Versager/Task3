package ShopSimulation;

import ru.vsu.cs.util.ArrayUtils;

import java.util.*;

public class Main {

    public static void startSimulation(String fileName){
        int[][] arr = ArrayUtils.readIntArray2FromFile(fileName);
        Shop shop = new Shop();
        for(int i =0; i<arr.length;i++){
            try {
                shop.addBuyer(arr[i]);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage()+" in line "+i);
            }
        }
        showResult(shop.resultOfSimulation());
    }

    public static void showResult(List<Buyer> buyers){
        System.out.println("Начало симуляции!");
        System.out.println();
        for(Buyer buyer: buyers){
            System.out.println("Покупатель со следующими данными:\nВремя прихода в магазин: "+buyer.getS()+
                    "\nВремя, потраченное на выбор товаров: "+buyer.getT()+
                    "\nКоличество товаров: "+buyer.getN()+"\nПокинет магазин в "+buyer.getLeftTime());
            System.out.println();
        }
        System.out.println("Конец симуляции!");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        startSimulation(scn.nextLine()); //F:\IdeaProjects\Task3aisd\src\Test.txt
    }
}
