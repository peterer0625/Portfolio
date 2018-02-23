import threading

class Counter(threading.Thread):
    count = 0

    def __init__(self, lock, name):
        super(Counter, self).__init__(None, None, None)

        self.lock = lock
        self.name = name


    def run(self):
        self.lock.acquire()
        for i in range(100000):
            Counter.count = Counter.count + 1
        self.lock.release()