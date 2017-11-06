from collections import defaultdict
class Solution(object):
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        parent = dict()
        def find_root(a):
            if parent[a] != a:
                parent[a] = find_root(parent[a])
            return parent[a]

        def link(ra, rb):
            parent[ra] = rb

        for acct in accounts:
            name = acct[0]
            for email in acct[1:]:
                parent.setdefault((email, name), (email, name))
            for email in acct[2:]:
                ra, rb = find_root((email, name)), find_root((acct[1], name))
                if ra != rb:
                    link(ra, rb)
        ans_mapping = defaultdict(list)
        for email, name in parent:
            ans_mapping[find_root((email, name))].append(email)
        ans = []
        for (email, name), l in ans_mapping.iteritems():
            acct = [name] + sorted(l)
            ans.append(acct)

        return ans
