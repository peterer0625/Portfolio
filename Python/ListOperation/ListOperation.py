import random

a = [1, 3, 5, 7, 9]
for i in a:
    print(i)

print()

for i in range(0, len(a)):
    print(a[i])

print()

value = random.randint(0, 101)
print(value)

random.shuffle(a)
print(a)