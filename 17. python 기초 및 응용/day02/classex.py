#클래스
class Calculator:
    def setdata(self, a, b): #첫번째 매개변수로 self 들어옴, 변수명은 변경 가능
        self.a = a #자바스크립트의 this와 비슷함
        self.b = b #a, b는 인스턴스 변수와 같다
        print(a+b)

cal1 = Calculator() #함수 형태로 호출하면 객체가 됨
cal1.setdata(10, 20) #self 변수 제외하고 순서대로 매개변수 값 투입됨
print(cal1.a, cal1.b)

cal2 = Calculator()
Calculator.setdata(cal2, 20, 30) #클래스명으로 호출할 때는 self 참조변수까지 입력해야 함
print(cal2.a, cal2.b)

cal3 = Calculator()
print(id(cal1), id(cal3)) #참조변수 주소 다름=다른 객체
