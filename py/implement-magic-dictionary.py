from collections import defaultdict
class Node(object):
    def __init__(self):
        self.end = False
        self._not = defaultdict(set)
        self.children = defaultdict(Node)

class MagicDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node()

    def buildDict(self, dict):
        """
        Build a dictionary through a list of words
        :type dict: List[str]
        :rtype: void
        """
        def dfs(depth, s, rem, out):
            if depth == len(s):
                if rem == 0:
                    yield out
            else:
                if rem:
                    out.append(s[depth].upper())
                    for x in dfs(depth + 1, s, 0, out):
                        yield x
                    out.pop()
                out.append(s[depth])
                for x in dfs(depth + 1, s, rem, out):
                    yield x
                out.pop()

        def insert_word(w):
            cur = self.root
            for i, c in enumerate(w):
                if c.isupper():
                    cur = cur.children['?']
                    cur._not[c.lower()].add(''.join(w[i + 1:]))
                    break
                else:
                    cur = cur.children[c]
            cur.end = True

        for d in dict:
            for word in dfs(0, d, 1, []):
                insert_word(word)


    def search(self, word):
        """
        Returns if there is any word in the trie that equals to the given word after modifying exactly one character
        :type word: str
        :rtype: bool
        """
        def do_search(cur, depth, w):
            if depth == len(w):
                return cur.end
            c = w[depth]
            nxt = cur.children.get(c)
            if nxt and do_search(nxt, depth + 1, w):
                return True
            nxt = cur.children.get('?')
            if nxt:
                for k, s in nxt._not.iteritems():
                    if k != c and w[depth + 1:] in s:
                        return True
            return False

        return do_search(self.root, 0, word)


# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dict)
# param_2 = obj.search(word)
