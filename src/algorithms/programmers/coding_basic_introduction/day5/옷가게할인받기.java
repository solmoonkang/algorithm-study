package algorithms.programmers.coding_basic_introduction.day5;

public class 옷가게할인받기 {

    /**
     * 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
     * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 반환하라
     */
    public int solution(int price) {
        double answer = 0;

        if (price < 100000) {
            answer = price;
        } else if (100000 <= price && price < 300000) {
            answer = price - (price * 0.05);
        } else if (300000 <= price && price < 500000) {
            answer = price - (price * 0.1);
        } else if (price >= 500000) {
            answer = price - (price * 0.2);
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        옷가게할인받기 discount = new 옷가게할인받기();
        System.out.println("Result: " + discount.solution(150000));
        System.out.println("Result: " + discount.solution(580000));
    }
}
