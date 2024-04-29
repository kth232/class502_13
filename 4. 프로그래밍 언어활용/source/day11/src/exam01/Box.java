package exam01;

//T는 Fruit의 하위 클래스로 한정->힌트 제공, 충분한 정보가 있으므로 Object가 아닌 Fruit로 변경
// Eatable 인터페이스 구현 시에도 추가 가능
// &로 클래스, 인터페이스 구별없이 상속 가능
public class Box<T extends Fruit & Eatable> { //Box<T>: 지네릭 클래스, T-타입 매개변수, Box-원시타입
    private T item;

    //private static T item2; // 사용 불가, 처음부터 공간 할당 받으므로 자료형이 명확해야 함
    //private static T[] nums = new T[3]; // 사용 불가, 배열에서 공간 생성을 위해서는 자료형이 명확해야 함
    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
    public String toString() {
        // item.get(); //Apple로 생각하고 get 메서드를 호출하려고 했는데 안됨
        // T==Objedt 클래스 내부에서는 무엇으로 바뀔지 모르기 때문에 Object로 되어있음
        return item.get(); //클래스 한정하면 get 메서드 호출 가능, 객체 생성 시 자료형 결정
    }
}
