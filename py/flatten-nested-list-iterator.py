# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.it = NestedIterator.mygenerator(nestedList)
        self.cache = None

    @staticmethod
    def mygenerator(nestedList):
        for ni in nestedList:
            if ni.isInteger():
                yield ni.getInteger()
            else:
                for v in NestedIterator.mygenerator(ni.getList()):
                    yield v

    def next(self):
        """
        :rtype: int
        """
        if self.cache is not None:
            out = self.cache
            self.cache = None
            return out
        else:
            return self.it.next()


    def hasNext(self):
        """
        :rtype: bool
        """
        try:
            self.cache = self.it.next()
            return True
        except StopIteration:
            return False


# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())
