import math

def main():
    comboCounts = [1, 1, 1, 2] ## stores the amount of possible combinations for index n. First four are trivial
    coins = [1, 4, 9, 16, 25, 36, 49, 64, 81]

    value = 0
    while value <= 0 or value >= 300:
        value = input("What value would you like the combinations for? ")

    findTotalCombinations(value, comboCounts)
    
def findTotalCombinations(n, found):
    if n in (1, 2, 3, 4):
        return found[n - 1] #because 0 based list

    for i in range(4, n):
        



if __name__ == "__main__":
    main()