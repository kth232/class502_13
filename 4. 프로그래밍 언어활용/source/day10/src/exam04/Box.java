package exam04;

public class Box<T> { //type: 자료형
    private T item;

    public void setItem(T item) { //타입 매개변수, Object->T
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}//지네릭 클래스
// 컴파일 시 무조건 완성된 자료형이 되어야 함->아니면 문법적 오류
// ->컴파일 실행되기 위해 문법적 오류(타입 변수) 제거->부족한 부분은 object로 채움(∵다른 건 몰라도 object는 알고 있음)

/* // 컴파일을 위해 변경된 상태
public class Box { //type: 자료형
    private Object item;

    public void setItem(Object item) { //타입 매개변수, Object->T
        this.item = item;
    }
    public Object getItem() {
        return item;
    }
}
 */

//-> 객체 생성 시 투입된 자료형으로 Object->형변환 ex)Object->Apple