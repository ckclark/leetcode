from collections import Counter
import random
class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.counter = Counter()
        self.redundant = Counter()
        self.array = []


    def insert(self, val):
        """
        Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
        :type val: int
        :rtype: bool
        """
        self.counter[val] += 1
        if self.redundant[val] == 0:
            self.array.append(val)
        else:
            self.redundant[val] -= 1
        return self.counter[val] == 1

    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        ret = False
        if self.counter[val]:
            ret = True
            self.counter[val] -= 1
            self.redundant[val] += 1
        return ret


    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        while True:
            idx = random.randint(0, len(self.array) - 1)
            v = self.array[idx]
            if self.counter[v] and (self.redundant[v] == 0 or random.random() * (self.counter[v] + self.redundant[v]) < self.counter[v]):
                break
            else:
                self.array[idx] = self.array[-1]
                self.array.pop()
                self.redundant[v] -= 1
        return v



# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
