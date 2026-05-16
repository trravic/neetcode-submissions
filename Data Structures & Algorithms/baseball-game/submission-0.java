class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String opn : operations){
            switch(opn){
                case "D":
                    stack.push(Integer.valueOf(stack.peek()) * 2) ;
                    break;
                case "+":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1);
                    stack.push(num2);
                    stack.push(num1 + num2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(opn));
                    break;
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}