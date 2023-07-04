package codingTest.level2;

public class 숫자의표현 {

    public int expressionOfNumbers(int n) {
        int answer = 1;

        for(int i = 1; i <= n; i++){
            int sum = i;

            for(int j = i+1; j <= n; j++){  // 연속된 숫자를 찾기 위해서 반복문을 통해 1씩 증가시킨다
                sum += j;

                if(sum == n){   // 연속된 숫자의 합이 구해야 하는 숫자와 같을 경우 개수를 증가시킨 후 빠져나온다
                    answer++;
                    break;
                }else if(sum > n){  // 연속된 숫자의 합이 구해야 하는 숫자보다 클 경우 빠져나온다
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        숫자의표현 solution = new 숫자의표현();
        System.out.println("result :" + solution.expressionOfNumbers(15));
    }
}
