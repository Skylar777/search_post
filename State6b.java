public class State6b 
{    
	
    int[] puzzleArray;
    
    //It has to be a copy of values not reference because we will 
    public State6b(int[] puzzleArray){
        this.puzzleArray=puzzleArray;
    }
    //create many states and don't want to overwrite the same array.
    public State6b(State6b state) {
    	
    	puzzleArray = new int[7];
    	
        for(int i=0; i<7; i++){
        	this.puzzleArray[i] = state.puzzleArray[i];
        }
        
    }
    
    public boolean equals(Object o) {
        State6b state = (State6b) o;
        for (int i=0; i<7; i++)
        {
            if(this.puzzleArray[i]!=state.puzzleArray[i])
                return false;
        }
        return true;
    }
    
    public int hashCode() {
        return puzzleArray[0]*1000000 + puzzleArray[1]*100000 + puzzleArray[2]*10000 + puzzleArray[3]*1000 + puzzleArray[4]*100 + puzzleArray[5]*10 + puzzleArray[6]*1;
    }    
    
    public String toString() {
    	String returned="";
        for (int i=0;i<7;i++){
            returned +=" "+this.puzzleArray[i];

        }
        return returned;
    }
}