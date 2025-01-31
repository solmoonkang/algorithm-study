## 깊이 우선 탐색 (DFS, Depth-First Search)

---

트리나 그래프를 탐색하는 기법 중 하나로, 시작 노드에서 자식 노드들을 순서대로 탐색하며 깊이를 우선하여 탐색하는 알고리즘이다.

깊이를 우선시하여 모든 경우의 수를 탐색하기 때문에, 완전 탐색 알고리즘에 속하기는 하지만,

항상 완전 탐색으로 사용되지는 않는다.

DFS는 주로 반복문을 활용하거나, 재귀문을 통해 구현된다.

## DFS의 탐색 과정

DFS의 기본 탐색 과정은 특정 정점에서 시작하여 역추척(backtracing) 하기 전에 각 분기를 따라 가능한 한 멀리 탐색하는 것이다.

탐색하는 과정은 다음과 같다.

1. 현재 노드를 방문한 것으로 표시한다.
2. 방문한 표시가 되어 있지 않은 각각의 인접한 정점을 탐색한다.
3. 더 이상 방문하지 않은 정점이 없으면, 이전 정점으로 역추척(backtracing)한다.
4. 모든 정점을 방문할 때까지 프로세스를 반복한다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/c33fee58-8f40-4523-b222-c56099de30a9/8c3a1037-778e-4af0-b402-7d964656b0ad/Untitled.png)

---

1. 다음과 같이 있을 때, 시작 노드인 0번 노드에서 자식 노드인 1번과 2번 노드를 탐색할 수 있다.

   만약, 1번 노드를 탐색하기로 결정하면, 1번 노드를 완벽히 탐색하기 전까지는 2번 노드를 탐색하지 않는다.

2. 그러다가 3번 노드까지 와서 자식 노드가 7번 노드뿐이므로, 해당 노드를 방문하고 탐색 완료 표시를 하고 다시 3번 노드로 돌아간다.
3. 마찬가지로 3번 노드도 탐색이 끝났기 때문에 탐색 완료 표시를 하고 1번 노드로 돌아간다.
4. 위 과정을 반복한다.

## DFS의 장단점

DFS의 장점은 다음과 같다:

1. DFS는 현재 순회 중인 정점만 저장하는 스택 데이터 구조를 사용하기 때문에 BFS에 비해 메모리 공간을 덜 차지한다.
2. DFS는 목표가 특정 정점(또는 모든 정점)에 최대한 빨리 도달하는 것일 때 유용하다.
3. DFS를 사용하면 그래프에서 순환을 감지할 수 있다.

DFS의 단점은 다음과 같다:

1. 순환 그래프의 경우 DFS가 무한 루프에 빠질 수 있다.
2. DFS는 두 정점 사이의 최단 경로를 찾으려는 경우 사용하기에 가장 좋은 알고리즘이 아닐 수 있다.

DFS는 특정 시나리오에서 매우 유용하지만 최선의 선택은 아니다.

따라서 해결하려는 특정 문제에 따라 BFS와 같은 다른 알고리즘이 더 적합할 수 있다.

## DFS 구현 방법

---

### 반복 구현 (Stack 활용)

반복 구현에서는 스택 데이터 구조를 사용하여 방문할 정점을 추적한다.

1. 알고리즘은 임의읭 정점에서 시작하여 방문한 것으로 표시하고 스택에 푸시한다.
2. 스택에서 맨 위 정점을 가져온다.
3. 방문하지 않은 모든 인접 정점을 방문하여 방문한 것으로 표시하고 스택으로 푸시한다.
4. 스택이 비워질 때까지 프로세스를 반복한다.

```java
public class 스택을활용한깊이우선탐색 {

    /**
     * 반복 구현 (Stack 활용):
     *  - 반복 구현에서는 스택 데이터 구조를 사용하여 방문할 정점을 추적한다.
     * 1. 알고리즘은 임의의 정점에서 시작하여 방문한 것으로 표시하고 스택에 푸시한다.
     * 2. 스택에서 맨 위 정점을 가져온다.
     * 3. 방문하지 않은 인접 정점을 방문하여 방문한 것으로 표시하고 스택으로 푸시한다.
     * 4. 스택이 비워질 때까지 해당 프로세스를 반복한다.
     */

    private static List<Integer>[] adjacency;

    private static boolean[] visited;

    public static void depthFirstSearch(int V) {

        Deque<Integer> stack = new LinkedList<>();
        stack.push(V);
        visited[V] = true;

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.println("방문 정점 = " + vertex + " ");

            for (int neigbor : adjacency[vertex]) {
                if (!visited[neigbor]) {
                    stack.push(neigbor);
                    visited[neigbor] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        adjacency = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjacency[i] = new ArrayList<>();
            visited[i] = false;
        }

        adjacency[0].add(1);
        adjacency[0].add(2);
        adjacency[1].add(2);
        adjacency[2].add(0);
        adjacency[2].add(3);
        adjacency[3].add(3);

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
            }
        }

    }
}
```

### 재귀 구현

재귀 구현에서는 재귀 함수를 사용하여 그래프의 모든 정점을 방문한다.

이 함수는 현재 정점과 방문한 집합을 입력으로 사용하고 아직 방문하지 않은 모든 인접 정점에 DFS를 적용한다.

- 따라서 재귀는 모든 정점을 방문하는 사례에서 유용하다.

```java
public class 재귀함수를활용한깊이우선탐색 {

    /**
     * 재귀 구현:
     * 현재 정점과 방문한 집합을 입력으로 사용하고, 아직 방문하지 않은 모든 인접 정점에 DFS를 적용한다.
     * 모든 정점을 방문하는 사례에서 재귀 구현은 유용하다.
     */

    private static List<Integer>[] adjacency;

    private static boolean[] visited;

    public static void depthFirstSearch(int V) {
        visited[V] = true;
        System.out.println("V = " + V + " ");

        for (int neighbor : adjacency[V]) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        adjacency = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            adjacency[i] = new ArrayList<>();
            visited[i] = false;
        }

        adjacency[0].add(1);
        adjacency[0].add(2);
        adjacency[1].add(2);
        adjacency[2].add(0);
        adjacency[2].add(3);
        adjacency[3].add(3);

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
            }
        }
    }
}
```

---

두 방법 모두 시간 및 공간 복잡도는 동일하지만,

반복 구현은 일반적으로 호출 스택을 사용하지 않기 때문에 공간 측면에서 더 효율적이라고 간주된다.

반면, 재귀 구현은 반복 구현보다 더 간단하여 읽기 쉽다.

하지만 그래프가 커지거나 순환이 있는 경우 재귀를 사용하면 스택 오버플로우가 발생할 수 있다.