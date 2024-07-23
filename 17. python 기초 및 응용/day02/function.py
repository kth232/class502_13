#함수
#들여쓰기로 수행 코드 정의
def add(a, b):
    return a + b

result = add(20,30)
print(result)

print(add(10, 20))

# 기본값 정의 가능
def minus(a, b = 5):
    return a - b

#변수 할당 가능
print(minus(a=20, b=10))
print(minus(b=20, a=10))
print(minus(30))

#기본값 설정이 가능하기 때문에 메서드 오버로드가 필요없다
#단, 기본값을 설정할 땐 가장 마지막 매개변수부터 지정해야 함
def add2(a, b = 20): #b 기본값=20
    return a + b

result = add2(10) #b=20
print(result)

'''
#에러 발생
def add(a=10, b): #a 기본값=10
    return a + b

result = add(20) #b=20?
print(result)
'''

def add3(*args):
    print(args)

add3(10, 20, 30, 40) #튜플형으로 반환


def calc(opr, *args): #*변수=가변적인 변수
    result = 0 #덧셈, 뺄셈이어서 가능, 곱셈은 1로 변경
    if opr == 'add':
        for num in args:
            result += num
    elif opr == 'minus':
        for num in args:
            result -= num
    elif opr == 'null':
        result = 1
        for num in args:
            result *= num

    return print(result)


calc('add', 10, 20, 30)
calc('null', 10, 20, 30)


def keywords(**kwargs):
    print(kwargs)


keywords(name='lee', age=40) #변수명 지정 가능, 맵 형태로 리턴


def allKeywords(*args, **kwargs):
    print(args)
    print(kwargs)

#변수명을 지정하지 않으면 args에, 변수명을 지정하면 kwargs에 대입됨, 튜플형으로 반환
allKeywords(10, 20 ,30, name="kim", age=50)

#함수는 리턴값을 내보내면 종료->연산 중간에 빠져나가기 위해 리턴을 사용하는 경우도 있음
def calc2(a, b):
    return a+b, a-b, a*b #튜플형 반환, 리턴값은 언제나 하나
print(calc2(10,20))


def calc3(a, b):
    return a+b
    return a-b
    return a*b

print(calc3(10, 20))
#값을 리턴하면 함수는 종료되므로 a+b값을 리턴하고 이후는 수행하지 않는다.

a = 10 #전역 변수 a
def add(): #지역변수 a
    global a #전역변수 직접 접근, 순수하지 못한 함수->외부에 영향을 받기 때문
    a += 1

add()
print(a)

#람다식
nums = [i for i in range(1, 11)]
'''
def square(num): #제곱하는 함수
    return num * num

nums2 = list(map(square, nums))
print(nums2)
'''

nums2 = list(map(lambda a: a * a, nums));
print(nums2)
