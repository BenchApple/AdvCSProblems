import math

def main():
    counts = [1]
    coins = [4, 9, 16, 25, 36, 49, 64, 81] #No 1 in the list because it causes problems later down the line.

    value = -1
    while value < 0 or value > 300:
        value = input("What value would you like the combinations for? ")

    print(findTotalCombinations(value, counts, coins))
    
def findTotalCombinations(n, counts, coins): ## Solves the problem in a way very similar to a fibonacci sequence.
    if n == 1:
        return counts[0] #because 0 based list

    else:
        for i in range(2, n + 1): ##Goes through each of the values up to n. 
            count = counts[i-2]

            for j in coins:
                if i % j == 0:
                    count += 1
                elif i < j:
                    break
            counts.append(count)
    
        return counts[len(counts) - 1]    

if __name__ == "__main__":
    main()