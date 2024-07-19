#함수
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
