import java.util.HashSet;
import java.util.Set;

public class Problem6b extends Problem {

	int c1=0;
	int c2=1;
	int c3=2;
	int m1=3;
	int m2=4;
	int m3=5;
	int boat=6;
    
	boolean goal_test(Object state) {
        State6b puzzle_state = (State6b) state;
        if (puzzle_state.puzzleArray[0]==1 && puzzle_state.puzzleArray[1]==1 && puzzle_state.puzzleArray[2]==1 && puzzle_state.puzzleArray[3]==1 && puzzle_state.puzzleArray[4]==1 && puzzle_state.puzzleArray[5]==1 && puzzle_state.puzzleArray[6]==1)
			return true;
		return false;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
        State6b s = (State6b) state;
        State6b ss; //successor state
        //boat cannibals
        ss = new State6b(s);
        ss.puzzleArray[boat]-=1;
		ss.puzzleArray[c1]-=1;
		if (isValid(ss))
			set.add(ss);
			
		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[c1]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("cabbage here");
		
		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[c2]-=1;
		if (isValid(ss))
			set.add(ss);
			
		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[c2]+=1;
		if (isValid(ss))
			set.add(ss);

		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[c3]-=1;
		if (isValid(ss))
			set.add(ss);
			
		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[c3]+=1;
		if (isValid(ss))
			set.add(ss);

		// boat missionaries
		ss = new State6b(s);
        ss.puzzleArray[boat]+=1;
		ss.puzzleArray[m1]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("goat there");

		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[m1]-=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println(set);
			//System.out.println("goat here");
		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[m2]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("goat there");

		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[m2]-=1;
		if (isValid(ss))
			set.add(ss);

		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		ss.puzzleArray[m3]+=1;
		if (isValid(ss))
			set.add(ss);
			//System.out.println("goat there");

		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		ss.puzzleArray[m3]-=1;
		if (isValid(ss))
			set.add(ss);
  
			//System.out.println(set);
			//System.out.println("wolf here");
		ss = new State6b(s);
		ss.puzzleArray[boat]+=1;
		if (isValid(ss)) 
			set.add(ss);
			
		ss = new State6b(s);
		ss.puzzleArray[boat]-=1;
		if (isValid(ss)) 
				set.add(ss);

        return set;
    }
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { 
		//return 0;
		State6b newstate = (State6b) state;
        return 2*(newstate.puzzleArray[c1]+newstate.puzzleArray[c2]+newstate.puzzleArray[c3]+newstate.puzzleArray[m3]+newstate.puzzleArray[m2]+newstate.puzzleArray[m1])-1; 
	}

	private boolean isValid(State6b state){
		int leftcan=0;
		int leftmis=0;
		int rightcan=0;
		int rightmis=0;
		for (int i=0; i<7; i++){
			if(state.puzzleArray[i]<0 || state.puzzleArray[i]>1){
				return false;
			}
		}
		if(state.puzzleArray[m1]==0){
			leftmis++;
		}else{
			rightmis++;
		}
		if(state.puzzleArray[m2]==0){
			leftmis++;
		}else{
			rightmis++;
		}
		if(state.puzzleArray[m3]==0){
			leftmis++;
		}else{
			rightmis++;
		}
		if(state.puzzleArray[c1]==0){
			leftcan++;
		}else{
			rightcan++;
		}
		if(state.puzzleArray[c2]==0){
			leftcan++;
		}else{
			rightcan++;
		}
		if(state.puzzleArray[c3]==0){
			leftmis++;
		}else{
			rightcan++;
		}
		if(state.puzzleArray[boat]==0 && rightcan>rightmis)
			return false;
		if(state.puzzleArray[boat]==1 && leftcan>leftmis)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		// Problem6b wolfproblem = new Problem6b();
		// int[] wolfpuzzleArray = {0,0,0,0};
		// wolfproblem.initialState = new State6b(wolfpuzzleArray); 
		
		// Problem6b wolfproblem = new Problem6b();
		// int[][] wolfpuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// wolfproblem.initialState = new State6b(wolfpuzzleArray); 

		// ProblemWCG problem = new ProblemWCG();
		// HashMap<String, Boolean> otherSide = new HashMap<String, Boolean>();
		// otherSide.put("wolf", false);
		// otherSide.put("goat", false);
		// otherSide.put("cabbage", false);
		// otherSide.put("farmer", false);
		// problem.initialState = new StateWCG(otherSide);

		Problem6b cannibalproblem = new Problem6b();
		int[] cannibalpuzzleArray = {0,0,0,0,0,0,0};
		cannibalproblem.initialState = new State6b(cannibalpuzzleArray); 

		// Problem6b pancakeproblem = new Problem6b();
		// int[][] pancakepuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// pancakeproblem.initialState = new State6b(pancakepuzzleArray); 
		
		Search search  = new Search(cannibalproblem);

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
