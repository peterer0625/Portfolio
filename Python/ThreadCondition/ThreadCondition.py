import threading
import time

class Hider(threading.Thread):
    def __init__(self, condition):
        super().__init__()
        self._condition = condition

    def run(self):
        self._condition.acquire()

        self._condition.wait()
        print("I am hiding")
        print("I already hid. You can try to find me.")
        self._condition.notify()
        self._condition.wait()

        print("OK. you win.")
        self._condition.notify()

        self._condition.release()

class Seeker(threading.Thread):
    def __init__(self, condition):
        super().__init__()
        self._condition = condition

    def run(self):
        time.sleep(1)
        self._condition.acquire()

        print("I already closed eye. You can hide.")
        self._condition.notify()
        self._condition.wait()

        print("I am finding.")
        print("I find you")
        self._condition.notify()
        self._condition.wait()

        print("I win")

        self._condition.release()


condition = threading.Condition()
Hider(condition).start()
Seeker(condition).start()