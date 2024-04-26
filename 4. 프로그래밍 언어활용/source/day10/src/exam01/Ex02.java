package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS;
        Enum <Transportation> trans2 = trans;
        switch(trans) {
            case BUS: //이미 투입된 값으로 불러오기 가능
                System.out.println("bus");
                break;
            case SUBWAY:
                System.out.println("subway");
                break;
            case TAXI:
                System.out.println("taxi");
                break;
            default:
                System.out.println("walk");
        }
    }
}
