class Student:
    def __init__(self, name, grade, age):
        self.set_name(name)
        self.set_grade(grade)
        self.set_age(age)

    def set_name(self, name):
        self._name = name

    def get_name(self):
        return self._name

    def set_grade(self, grade):
       self._grade = grade

    def get_grade(self):
        return self._grade

    def set_age(self, age):
        self._age = age

    def get_age(self):
        return self._age


studentList = []
studentList.append(Student("Peter", "A", 18))
studentList.append(Student("Tom", "B", 17))

for i in studentList:
    print (i.get_name() + " " + i.get_grade() + " " + str(i.get_age()))
