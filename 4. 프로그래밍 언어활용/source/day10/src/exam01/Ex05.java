package exam01;

public class Ex05 {
    public static void main(String[] args) {
        String tran1= "BUS";
        //Transportation BUS = Enum.valueOf(Transportation.class, tran1); //어떤 클래스의 객체에 접근하는지 알려주기 위해 사용, class클래스가 정보성 객체이기 때문에 참고하는 것
        //System.out.println(BUS.name());
        Transportation BUS = Transportation.valueOf(tran1); //호출 객체가 Enum 상수이므로 Class 객체 x
        System.out.println(BUS == Transportation.BUS);

        Transportation TAXI = Transportation.valueOf("TAXI");
        System.out.println(TAXI == Transportation.TAXI);
    }
}
