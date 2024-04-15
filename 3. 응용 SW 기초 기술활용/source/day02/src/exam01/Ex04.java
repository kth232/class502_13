package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int floor= 7;
        switch(floor) {
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
                System.out.println("5f 이비인후과");
                break;
            default:
                System.out.println("no floor");;
        }
    }
}
