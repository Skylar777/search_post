public class State6a 
{    
	
    int[] puzzleArray;
    
    //It has to be a copy of values not reference because we will 
    public State6a(int[] puzzleArray){
        this.puzzleArray=puzzleArray;
    }
    //create many states and don't want to overwrite the same array.
    public State6a(State6a state) {
    	
    	puzzleArray = new int[4];
    	
        for(int i=0; i<4; i++){
        	this.puzzleArray[i] = state.puzzleArray[i];
        }
        
    }
    
    public boolean equals(Object o) {
        State6a state = (State6a) o;
        for (int i=0; i<4; i++)
        {
            if(this.puzzleArray[i]!=state.puzzleArray[i])
                return false;
        }
        return true;
    }
    
    public int hashCode() {
        return puzzleArray[0]*1000 + puzzleArray[1]*100 + puzzleArray[2]*10 + puzzleArray[3]*1;
    }    
    
    public String toString() {
    	String returned="";
        for (int i=0;i<4;i++){
            returned +=" "+this.puzzleArray[i];

        }
        return returned;
    }
}