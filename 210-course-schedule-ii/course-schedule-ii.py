class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        prerequi = {i : [] for i in range(numCourses)}
        visited = set()
        visiting = set()
        res = []

        for crs, pre in prerequisites:
            prerequi[crs].append(pre)

        def dfs(course):
            if course in visiting:
                return False
            if course in visited:
                return True
            
            visiting.add(course)

            for adj in prerequi[course]:
                if not dfs(adj):
                    return False

            visiting.remove(course)
            visited.add(course)
            res.append(course)
            return True

        for crs in range(numCourses):
            if not dfs(crs):
                return []

        return res

        
            
