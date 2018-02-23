import threading
from Counter import Counter

lock = threading.Lock()
threadPool = []
for i in range(5):
    threadPool.append(Counter(lock, "thread-" + str(i)))
    threadPool[i].start()

for i in threadPool:
    i.join()

print(Counter.count)