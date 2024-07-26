package programmers.모든문제.level1.전체문제;

public class 콜라문제 {

    /**
     * [ 문제 설명 ]
     * 오래전 유행했던 콜라 문제가 있습니다. 콜라 문제의 지문은 다음과 같습니다.
     * 콜라 빈 병 2개를 가져다주면 콜라 1병을 주는 마트가 있다. 빈 병 20개를 가져다주면 몇 병을 받을 수 있는가?
     * 단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.

     * 상빈이가 푼 방법은 아래 그림과 같습니다.
     * 우선 콜라 빈 병 20병을 가져가서 10병을 받습니다.
     * 받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다.
     * 5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고, 또 2병을 모두 마신 뒤 가져가서 1병을 받습니다.
     * 받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤 가져가면 1병을 또 받을 수 있습니다.
     * 이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.
     *
     * 문제를 열심히 풀던 상빈이는 일반화된 콜라 문제를 생각했습니다.
     * 이 문제는 빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때,
     * 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다.
     * 기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면, 추가적으로 빈 병을 받을 순 없습니다.
     * 상빈이는 열심히 고심했지만, 일반화된 콜라 문제의 답을 찾을 수 없었습니다.
     * 상빈이를 도와, 일반화된 콜라 문제를 해결하는 프로그램을 만들어 주세요.
     *
     * 콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b,
     * 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다.
     * 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
     */

    /**
     * [ 제한 사항 ]
     * 1 ≤ b < a ≤ n ≤ 1,000,000
     * 정답은 항상 int 범위를 넘지 않게 주어집니다.
     */
    public int solution1(int a, int b, int n) {
        // TODO: 다시 한 번 풀어보자.
        // 새로운 콜라를 얻기 위해 필요한 병 수 = a
        // 빈 병을 교환할 때 받게 되는 콜라 병 수 = b
        // 상빈이가 처음에 가지고 있는 빈 병의 총 수 = n

        int totalCola = 0;

        // 상빈이가 가지고 있는 빈 병의 수가 더 이상 콜라 한 병을 받기에 충분하지 않을 때까지 반복
        while (n >= a) {
            // 상빈이가 갖고 있는 빈 병으로 교환할 수 있는 콜라의 수를 계산
            int newCola = n / a;

            // 새로 교환하여 받은 콜라의 수를 총 콜라 수에 더함
            totalCola += newCola;

            // 새로 받은 콜라를 마시고 난 후의 빈 병(newCola * b)과
            // 처음에 교환할 때 남은 빈 병(n % a)을 합쳐서 새로운 빈 병의 총 수를 계산
            n = newCola * b + n % a;
        }

        return totalCola;
    }

    public int solution2(int a, int b, int n) {
        int totalCoke = 0;

        while (n >= a) {
            int newCoke = n / a;
            totalCoke += newCoke;
            n = (newCoke * b) + (n % a);
        }

        return totalCoke;
    }

    public static void main(String[] args) {
        콜라문제 problemCola = new 콜라문제();

        System.out.println("problemCoke = " + problemCola.solution1(2, 1, 20));
        System.out.println("problemCoke = " + problemCola.solution1(3, 1, 20));

        System.out.println("problemCoke = " + problemCola.solution2(2, 1, 20));
        System.out.println("problemCoke = " + problemCola.solution2(3, 1, 20));
    }
}
