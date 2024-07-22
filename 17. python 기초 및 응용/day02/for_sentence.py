# print()
print("abc", end='') #줄개행 안함
print("def")
print('') #줄개행
print('가나다')

#일반적인 for문
fruits = ["apple", "melon", "mango", "banana"]
for fruit in fruits:
    print(fruit)

#튜플 요소는 소괄호 가능-> 값쌍을 변수처럼 분해해서 할당 가능
nums = [(10, 20), (30, 40), (50, 60)]
for num in nums:
    print(num)

for (n1, n2) in nums:
    print("%d + %d = %d" % (n1, n2, n1+n2))

#소괄호 생략 가능
for n1, n2 in nums:
    print("%d + %d = %d" % (n1, n2, n1+n2))

#문자열 반복
for ch in "abcde":
    print(ch)


#리스트를 이용한 for문
nums2 = [10, 20, 30, 40, 50]
newNums = []
for num in nums2:
    newNums.append(num * num)
print(newNums)

#간략하게 작성 가능, list comprehension: 데이터를 리스트에 담아서 한번에 출력하는 것
nums2 = [10, 20, 30, 40, 50]
newNums2 = [num * num for num in nums2]
print(newNums2)

#range()
a = range(10)
print(a)
for b in a:
    print("%d 반복" % b)


for i in range(10): #range(0, 10)
    print("%d번 반복" % (i+1))

#1~10까지 리스트
nums3 = [i for i in range(1, 11)]
print(nums3)

#for문과 if문 함께 수행 가능
#반복문을 먼저 수행해서 숫자를 뽑고 조건식을 수행해서 짝수만 골라서 리스트를 만든다
nums4 = [i for i in range(1, 11) if i % 2 == 0]
print(nums4)

#구구단 출력
#for, range를 이용한 구구단
for i in range(2, 10): #2~9
    print("---%d단---" % i)
    for j in range(1, 10): #1~9
        print("%d x %d = %d"% (i, j, i*j))
'''
#리스트 데이터이기 때문에 줄개행 불가
gugudan = ["%d x %d = %d" % (i, j, i*j) for i in range(2, 10) for j in range(1, 10)]
print(gugudan)
for s in gugudan: #줄개행하려면 반복 출력하는 수 밖에..
    print(s)
'''