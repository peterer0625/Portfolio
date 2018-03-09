import twstock
import time

stockNumber = "2105"
stock = twstock.Stock(stockNumber)

stockDataList = []

print("Loading...")
for i in range(12):
    time.sleep(2)
    print("Loading...")
    stockDataList = stockDataList + stock.fetch(2016, i)

try:
    file = open(stockNumber + ".txt", "w")
    for i in range(len(stockDataList) - 21):
        for j in range(21):
            print(str(stockDataList[i + j].close) + " ")
            file.write(str(stockDataList[i + j].close) + " ")
        file.write("\n")
        print("")

except:
    print("File error")
finally:
    file.close()