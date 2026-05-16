class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> hmap = new HashMap<>();
        hmap.put(')' , '(');
        hmap.put('}' , '{');
        hmap.put(']' , '[');

        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == hmap.get(c)) // at any point of time, we are chcking the opening braces of ( { [ only
            {
                stack.pop(); // removes the opening bracket
            } else {
                //stack is empty or not matches
                if(stack.isEmpty() && hmap.containsKey(c)){
                    // stack is empty and close bracket comes 
                    return false;
                } else {
                    // if hashmap doesnt contains key
                   stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}


