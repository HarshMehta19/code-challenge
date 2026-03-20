class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        
        # Kanh's algorith
        indegree = [0] * numCourses
        adj = [[] for _ in range(numCourses)]
        for src, dst in prerequisites:
            indegree[dst] +=1
            adj[src].append(dst)

        q = deque()
        for n in range(numCourses):
            if indegree[n] == 0:
                q.append(n)
        res = []
        finish = 0
        while q:
            crs = q.popleft()
            finish +=1
            res.append(crs)

            for nei in adj[crs]:
                indegree[nei] -=1
                if indegree[nei] == 0:
                    q.append(nei)

        if finish != numCourses:
            return []
        
        return res[::-1]

        
        # prerequi = {i : [] for i in range(numCourses)}
        # visited = set()
        # visiting = set()
        # res = []

        # for crs, pre in prerequisites:
        #     prerequi[crs].append(pre)

        # def dfs(course):
        #     if course in visiting:
        #         return False
        #     if course in visited:
        #         return True
            
        #     visiting.add(course)

        #     for adj in prerequi[course]:
        #         if not dfs(adj):
        #             return False

        #     visiting.remove(course)
        #     visited.add(course)
        #     res.append(course)
        #     return True

        # for crs in range(numCourses):
        #     if not dfs(crs):
        #         return []

        # return res