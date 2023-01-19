import java.util.HashSet;
import java.util.Set;

public class Problem6c extends Problem {

	
    
	boolean goal_test(Object state) {
        State6c puzzle_state = (State6c) state;
		for(int i=0; i<(puzzle_state.puzzleArray.length-1); i++){
			if(puzzle_state.puzzleArray[i]>puzzle_state.puzzleArray[i+1]){
				return false;
			}
		}
		return true;
	}
  
    Set<Object> getSuccessors(Object state) {
    	
        Set<Object> set = new HashSet<Object>();
        State6c s = (State6c) state;
        State6c ss; //successor state
		
        //boat cannibals
        // ss = new State6c(s);
        // ss.puzzleArray[boat]-=1;
		// ss.puzzleArray[c1]-=1;
		// if (isValid(ss))
		// 	set.add(ss);
			
		// ss = new State6c(s);
		// ss.puzzleArray[boat]+=1;
		// ss.puzzleArray[c1]+=1;
		// if (isValid(ss))
		// 	set.add(ss);
		//System.out.println("cabbage here");
		
		ss=new State6c(s);
		//Set<Object> settemp = new HashSet<Object>();
		//settemp.add(ss);
		//System.out.println("before "+settemp);
		for (int i=0; i<s.N; i++){
			
			State6c sstemp= new State6c(s);
			//code
			int j=0;
			for (int p=i; p>=0; p--){
				sstemp.puzzleArray[j]=ss.puzzleArray[p];
				j++;
			}
			ss=sstemp;
			//complete isvalid
			// if(isValid(ss))
			// 	set.add(ss);
			//settemp.add(ss);
			//System.out.println("after "+settemp);
		}
		//repeat whole segment
		if(isValid(ss))
			set.add(ss);
			//System.out.println("after "+set);
        return set;
    }
	
	double step_cost(Object fromState, Object toState) { return 1; }

	public double h(Object state) { 
		return 0;
		// State6c newstate = (State6c) state;
        // return 2*(newstate.puzzleArray[c1]+newstate.puzzleArray[c2]+newstate.puzzleArray[c3]+newstate.puzzleArray[m3]+newstate.puzzleArray[m2]+newstate.puzzleArray[m1])-1; 
	}

	private boolean isValid(State6c state){
		// int leftcan=0;
		// int leftmis=0;
		// int rightcan=0;
		// int rightmis=0;
		// for (int i=0; i<7; i++){
		// 	if(state.puzzleArray[i]<0 || state.puzzleArray[i]>1){
		// 		return false;
		// 	}
		// }
		// if(state.puzzleArray[m1]==0){
		// 	leftmis++;
		// }else{
		// 	rightmis++;
		// }
		// if(state.puzzleArray[m2]==0){
		// 	leftmis++;
		// }else{
		// 	rightmis++;
		// }
		// if(state.puzzleArray[m3]==0){
		// 	leftmis++;
		// }else{
		// 	rightmis++;
		// }
		// if(state.puzzleArray[c1]==0){
		// 	leftcan++;
		// }else{
		// 	rightcan++;
		// }
		// if(state.puzzleArray[c2]==0){
		// 	leftcan++;
		// }else{
		// 	rightcan++;
		// }
		// if(state.puzzleArray[c3]==0){
		// 	leftmis++;
		// }else{
		// 	rightcan++;
		// }
		// if(state.puzzleArray[boat]==0 && rightcan>rightmis)
		// 	return false;
		// if(state.puzzleArray[boat]==1 && leftcan>leftmis)
		// 	return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		// Problem6c wolfproblem = new Problem6c();
		// int[] wolfpuzzleArray = {0,0,0,0};
		// wolfproblem.initialState = new State6c(wolfpuzzleArray); 
		
		// Problem6c wolfproblem = new Problem6c();
		// int[][] wolfpuzzleArray = {{7,2,4}, {5,0,6}, {8,3,1}};
		// wolfproblem.initialState = new State6c(wolfpuzzleArray); 

		// ProblemWCG problem = new ProblemWCG();
		// HashMap<String, Boolean> otherSide = new HashMap<String, Boolean>();
		// otherSide.put("wolf", false);
		// otherSide.put("goat", false);
		// otherSide.put("cabbage", false);
		// otherSide.put("farmer", false);
		// problem.initialState = new StateWCG(otherSide);

		// Problem6c cannibalproblem = new Problem6c();
		// int[] cannibalpuzzleArray = {0,0,0,0,0,0,0};
		// cannibalproblem.initialState = new State6c(cannibalpuzzleArray); 

		Problem6c pancakeproblem = new Problem6c();
		int[] pancakepuzzleArray = {1,0,3,5,2,4};
		pancakeproblem.initialState = new State6c(pancakepuzzleArray); 
		
		Search search  = new Search(pancakeproblem);

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
