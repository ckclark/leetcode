from collections import defaultdict
class Node(object):
    def __init__(self):
        self.children = defaultdict(Node)
        self.end = False

class Solution(object):
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        root = Node()
        for w in dict:
            cur = root
            for c in w:
                cur = cur.children[c]
            cur.end = True

        ans = []
        for w in sentence.split():
            w_tmp = []
            cur = root
            for c in w:
                w_tmp.append(c)
                if c not in cur.children:
                    ans.append(w)
                    break
                else:
                    cur = cur.children[c]
                    if cur.end:
                        ans.append(''.join(w_tmp))
                        break
            else:
                ans.append(w)
        return ' '.join(ans)
