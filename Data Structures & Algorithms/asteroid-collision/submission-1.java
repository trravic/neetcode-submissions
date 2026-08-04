class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for(int a : asteroids){

            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
                // stack will always contains +ve elements 
                int diff = a + stack.peek();
                if(diff < 0){
                    // curr asteriod is -ve dominating 
                    // so remove the smaller +ve asteroid
                    stack.pop();
                } else if(diff > 0){
                    // stack.peek() -> +ve asteroid is dominating 
                    // you dont want to do anything meaning - you can destroy the curr asteroid -ve 
                    // dont want to add it to stack
                    a = 0;
                } else {
                    //diff == 0 
                    // both shld explode 
                    // curr asteroid -ve and stack.peek() +ve 
                    stack.pop();

                    a = 0;
                }
            }
            if(a!=0){
                stack.add(a);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
/**
positive asteroid -> goes in right direction 
negative asteroid -> goes in left direction 

when both right and left direction -> <- meets collision happens 

collision scenarios 

1. smaller one will explode 
2. if same size -> both will explode 
3. two asteroids moving in the same direction - never collide 


*/