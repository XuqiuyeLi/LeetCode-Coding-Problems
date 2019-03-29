// remove all the duplicates

public int[] dedup(int[] array) {
	if(array.length <= 1){
      return array;
    }
    int stackTop = -1;
    // case 1: if stackTop == next element,
    //			pop the stackTop (--), and remove all of the elements
    // case 2: if stackTop != next element, push into the stack		
    for(int i = 0; i < array.length; i++){
    	if(stackTop == -1 || array[stackTop] != array[i]){
    		array[++stackTop] = array[i];
    		// stackTop is now array[i]
    	}
    	else{
    		// find the duplicates
    		while(array[i] == array[stackTop] && i < array.length){
    			i++;
    		}
    		// find the first other element
    		if(i == array.length - 1){
    			if(stackTop == 0){  
              		return new int[]{};
          		}
    			return Arrays.copyOfRange(array, 0, stackTop);
    		}
    		else{
    			array[stackTop] = array[i];
    		}
    	}
    }
    return Arrays.copyOfRange(array, 0, stackTop + 1);
}