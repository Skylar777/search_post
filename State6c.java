public class State6c
{    
    //N can be changed to be any number.
	int N = 6;
    int[] puzzleArray;
    
    //It has to be a copy of values not reference because we will 
    public State6c(int[] puzzleArray){
        this.puzzleArray=puzzleArray;
        this.N=puzzleArray.length;
    }
    //create many states and don't want to overwrite the same array.
    public State6c(State6c state) {
    	this.N=state.puzzleArray.length;
    	puzzleArray = new int[N];
    	
        for(int i=0; i<N; i++){
        	this.puzzleArray[i] = state.puzzleArray[i];
        }
        
    }
    
    public boolean equals(Object o) {
        State6c state = (State6c) o;
        for (int i=0; i<N; i++)
        {
            if(this.puzzleArray[i]!=state.puzzleArray[i])
                return false;
        }
        return true;
    }
    
    public int hashCode() {
        int returned=0;
        int mult=1;
        for (int i=(N-1); -1<i; i--)
        {
            returned+=puzzleArray[i]*mult;
            mult*=10;

        }
        return returned;
    }    
    
    public String toString() {
    	String returned="";
        for (int i=0;i<N;i++){
            returned +=" "+this.puzzleArray[i];

        }
        return returned;
    }
}