#Benjamin Chappell  

def main():
    min = 3
    
    factorials = []
    getFactorials(factorials)
    print (factorials)

def getFactorials(array):
    for i in range(1, 10):
        if i == 1:
            array[i-1] = 1
        else:
            array[i-1] = i * array[i-2]

if __name__ == "__main__":
    main()
