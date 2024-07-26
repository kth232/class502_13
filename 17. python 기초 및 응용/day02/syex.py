#프로그램 입출력
import sys #모듈 가져오기

args = sys.argv[1:] #리스트 슬라이싱

for arg in args:
    print(arg.upper(), end='') #줄개행 없이 대문자로 변환해서 출력

print('')
print(args)
