package exam01;

public class Q3 {
    public static void main(String[] args) {
        int floor = 5;
        switch (floor) {
            case 1:
                System.out.println("1f 약국");
                break;
            case 2:
                System.out.println("2f 정형외과");
                break;
            case 3:
                System.out.println("3f 피부과");
                break;
            case 4:
                System.out.println("4f 치과");
                break;
            case 5:
                System.out.println("5f 헬스클럽");
                break;
            default:
                System.out.println("해당 층은 없는 층입니다.");
        }
    }
}
