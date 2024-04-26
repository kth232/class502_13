package exam02;

@Todo("todo1")
@Todo("todo2")
@Todo("todo3") //repeatable로 설정해서 반복 가능
public class Ex04 {
    public static void main(String[] args) {
        Class cls = Ex04.class;
        Todos todos = (Todos) cls.getAnnotation(Todos.class); //형변환
        Todo[] todo = todos.value(); //애너테이션 value가 배열 형태로 담김
        for (Todo t : todo) {
            System.out.println(t.value());
        }
    }
}
