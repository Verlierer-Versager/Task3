package CustomQueue;

public class Main {

    public static void main(String[] args) {
        CustomQueue que = new CustomQueue();

        System.out.println("is empty: " + que.isEmpty());

        que.add(0);
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);

        System.out.println("size: " + que.size());
        System.out.println("is empty: " + que.isEmpty());

        que.peek();
        System.out.println("size: " + que.size());

        que.poll();
        que.poll();
        System.out.println("size: " + que.size());

        que.add(1);
        while (!que.isEmpty()) {
            System.out.println(que.poll());
        }

        System.out.println("is empty: " + que.isEmpty());
        System.out.println("size: " + que.size());
    }
}
