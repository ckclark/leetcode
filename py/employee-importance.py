"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        self.employees = {e.id: e for e in employees}
        return self.do_getImportance(id)

    def do_getImportance(self, id):
        return self.employees[id].importance + sum(map(self.do_getImportance, self.employees[id].subordinates))
