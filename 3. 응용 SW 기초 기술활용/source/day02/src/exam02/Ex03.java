package exam02;

public class Ex03 {
    public static void main(String[] args) {
        //int[] nums = new int[] {10, 20, 30, 40}; // 배열 선언과 동시에 초기화
        int[] nums= {10, 20, 30, 40, 50, 60};

        //int[] nums;
        //nums =new int[] {10, 20, 30, 40}; //개행 가능
        // nums={10, 20, 30, 40} // 오류->개행 불가
        System.out.println("공간의 개수: "+nums.length);
        for (int i=0; i<nums.length;i++) {
            System.out.printf("%d번째: %d%n", i, nums[i]);
        }
    }
}
