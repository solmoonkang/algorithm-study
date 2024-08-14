package programmers.모든문제.level0.코딩테스트입문;

public class 치킨쿠폰 {

    // TODO: 쿠폰과 서비스 치킨을 계산하는 방법에 문제가 있었음. 서비스 치킨에서도 쿠폰이 발급되는 부분을 계산하지 못했음.
    public int solution(int chicken) {
        int totalServiceChicken = 0;
        int coupon = chicken;

        while (coupon >= 10) {
            int serviceChicken = coupon / 10;
            totalServiceChicken += serviceChicken;
            coupon = serviceChicken + (coupon % 10);
        }

        return totalServiceChicken;
    }

    public static void main(String[] args) {
        치킨쿠폰 chickenCoupon = new 치킨쿠폰();

        System.out.println("chickenCoupon = " + chickenCoupon.solution(100));
        System.out.println("chickenCoupon = " + chickenCoupon.solution(1081));
    }
}
