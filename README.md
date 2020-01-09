<h1> Introduction to Artificial Intelligence </h1>

This is a Java project, implementing the Search Agent algorithm in Artificial Intelligence without any exterior libraries.

<h3> Setting </h3>

The problem takes an input String identifying the basic setting; this setting is a two-dimensional grid, this String object
contains details about the world such as our main agent which is Iron Man, the main enemy which is Thanos and a bunch of Thano's
warriors and finally six infinity stones. Our goal state is for Iron Man to collect the six infinity stones with minimal damage recieved
from Thanos warriors also with constraint to have his health points highter than 50% in order to face Thanos face to face.

<h4> Search Strategies </h4>

Search Algorithms includes a strategy to search the state space for the goal state by applying different operators which created
new nodes with different state and this process is repeated until the search algorithm finds the goal state. Our AI agent can be given
more than the normal **BFS** (Breadth first search algorithm) or the **DFS** (Depth First Search algorithm, the problem extends to more
advanced search algorithms such as: 

  1) **Iterative Deepining Algorithm**
  2) **Uniform Cost Algorithm**
  3) **Greedy Search Algorithm with two Heuristic Functions**
  4) **A-star Search Algorithm with two Heuristic Functions**
  
 
<h5> Operatos </h5>

Search algorithms expand the state space by applying operators for each state and generates a new node in the state space for the
effect of applying some operator *o* on node *n* in state *s*; thus our problem had some of the operators such as

  1) Moving in four directions; *UP, DOWN, RIGHT, LEFT*
  2) Collecting infinity stones if in same cell as stone.
  3) Snapping fingers if IronMan has all six infinity stones.
