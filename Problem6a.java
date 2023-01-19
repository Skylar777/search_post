import java.util.HashSet;
import java.util.Set;

public class Problem6a extends Problem {

	int wolf=0;
	int goat=1;
	int cabbage=2;
	int boat=3;
    
	boolean goal_test(Object state) {
        State6a puzzle_state = (State6a) state;
        if (puzzle_state.puzzleArray[0]==1 && puzzle_state.puzzleArray[1]==1 && puzzle_state.puzzleArray[2]==1 && puzzle_state.puzzleArray[3]==1)
			return true;
		return false;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
        State6a s = (State6a) state;
        State6a ss; //successor state
        //boat cabbage
        ss = new State6a(s);
        ss.puzzleArray[boat]-=1;
		ss.puzzleArray[cabbage]-=1;
		if (isValid(ss))
			set.add(ss);
			
		ss = new State6a(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[cabbage]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("cabbage here");
		// boat goat
		ss = new State6a(s);
        ss.puzzleArray[boat]+=1;
		ss.puzzleArray[goat]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("goat there");

		ss = new State6a(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[goat]-=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println(set);
			//System.out.println("goat here");
        
		//boat wolf
		ss = new State6a(s);
        ss.puzzleArray[boat]+=1;
		ss.puzzleArray[wolf]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println(set);
			//System.out.println("wolf there");

		ss = new State6a(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[wolf]-=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println(set);
			//System.out.println("wolf here");
		ss = new State6a(s);
		ss.puzzleArray[boat]+=1;
		if (isValid(ss)) 
			set.add(ss);
			
		ss = new State6a(s);
		ss.puzzleArray[boat]-=1;
		if (isValid(ss)) 
				set.add(ss);

        return set;
    }
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { 
		State6a newstate = (State6a) state;
        return 2*(newstate.puzzleArray[cabbage]+newstate.puzzleArray[goat]+newstate.puzzleArray[wolf])-1; 
	}

	private boolean isValid(State6a state){
		for (int i=0; i<4; i++){
			if(state.puzzleArray[i]<0 || state.puzzleArray[i]>1){
				return false;
			}
		}
		if(state.puzzleArray[boat]!=state.puzzleArray[cabbage] && state.puzzleArray[cabbage]==state.puzzleArray[goat])
			return false;
		if(state.puzzleArray[boat]!=state.puzzleArray[wolf] && state.puzzleArray[wolf]==state.puzzleArray[goat])
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		Problem6a wolfproblem = new Problem6a();
		int[] wolfpuzzleArray = {0,0,0,0};
		wolfproblem.initialState = new State6a(wolfpuzzleArray); 
		
		// Problem6a wolfproblem = new Problem6a();
		// int[][] wolfpuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// wolfproblem.initialState = new State6a(wolfpuzzleArray); 

		// ProblemWCG problem = new ProblemWCG();
		// HashMap<String, Boolean> otherSide = new HashMap<String, Boolean>();
		// otherSide.put("wolf", false);
		// otherSide.put("goat", false);
		// otherSide.put("cabbage", false);
		// otherSide.put("farmer", false);
		// problem.initialState = new StateWCG(otherSide);

		// Problem6a cannibalproblem = new Problem6a();
		// int[][] cannibalpuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// cannibalproblem.initialState = new State6a(cannibalpuzzleArray); 

		// Problem6a pancakeproblem = new Problem6a();
		// int[][] pancakepuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// pancakeproblem.initialState = new State6a(pancakepuzzleArray); 
		
		Search search  = new Search(wolfproblem);

		System.out.println("TreeSearch------------------------");
		//System.out.println("BreadthFirstTreeSearch:\t\t" + search.BreadthFirstTreeSearch());
		//System.out.println("UniformCostTreeSearch:\t\t" + search.UniformCostTreeSearch());
		//System.out.println("DepthFirstTreeSearch:\t\t" + search.DepthFirstTreeSearch());
		//System.out.println("GreedyBestFirstTreeSearch:\t" + search.GreedyBestFirstTreeSearch());
		//System.out.println("AstarTreeSearch:\t\t" + search.AstarTreeSearch());
		
		System.out.println("\n\nGraphSearch----------------------");
		System.out.println("BreadthFirstGraphSearch:\t" + search.BreadthFirstGraphSearch());
		System.out.println("UniformCostGraphSearch:\t\t" + search.UniformCostGraphSearch());
		System.out.println("DepthFirstGraphSearch:\t\t" + search.DepthFirstGraphSearch());
		System.out.println("GreedyBestGraphSearch:\t\t" + search.GreedyBestFirstGraphSearch());
		System.out.println("AstarGraphSearch:\t\t" + search.AstarGraphSearch());
		
		System.out.println("\n\nIterativeDeepening----------------------");
		//System.out.println("IterativeDeepeningTreeSearch:\t" + search.IterativeDeepeningTreeSearch());
		System.out.println("IterativeDeepeningGraphSearch:\t" + search.IterativeDeepeningGraphSearch());
	}
	
}
