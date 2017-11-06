from collections import defaultdict
class Solution(object):
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        content_mapping = defaultdict(list)
        for s in paths:
            sp = s.split()
            dirpath = sp[0]
            for name_content in sp[1:]:
                name, content = name_content.split('(')
                content_mapping[content].append(dirpath + '/' + name)
        return [x for x in content_mapping.values() if len(x) > 1]
