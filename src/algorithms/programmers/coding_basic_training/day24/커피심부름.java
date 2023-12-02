package algorithms.programmers.coding_basic_training.day24;

public class 커피심부름 {

    public int solution(String[] order) {

        // 팀의 막내인 철수는 아메리카노와 카페 라테만 판매하는 카페에서 팀원들의 커피를 사려고 한다
        // 차갑거나 뜨거운 아메리카노는 4,500원, 차갑거나 뜨거운 카페 라떼 5,000원이다
        // 각 팀원에게 마실 메뉴를 적어달라 하였고,
        // 그 중 메뉴만 적은 팀원의 것은 차가운 것으로 통일하고 "아무거나"를 적은 팀원의 것은 차가운 아메리카노로 통일하였다
        // 카페에서 결제하게 될 금액을 반환하라

        int total = 0;

        for (int i = 0; i < order.length; i++) {

            if (order[i].contains("cafelatte")) {

                total += 5000;

            } else {

                total += 4500;
            }
        }

        return total;
    }

    public static void main(String[] args) {

        커피심부름 coffee = new 커피심부름();

        String[] order1 = {"cafelatte", "americanoice", "hotcafelatte", "anything"};
        String[] order2 = {"americanoice", "americano", "iceamericano"};

        System.out.println("Result : " + coffee.solution(order1));
        System.out.println("Result : " + coffee.solution(order2));
    }
}
