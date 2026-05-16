class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : (path + "/").toCharArray()){
            if(c == '/'){
                if(sb.toString().equals("..")){
                    if(!stack.isEmpty()) stack.pop();
                } else if(!sb.toString().equals("") && !sb.toString().equals(".")){
                    stack.push(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }

        return "/" + String.join("/", stack);
    }
}

/**
        // . -> current directory
        // .. -> move up one directory
        // // -> /
        // if more tha two dots(.....) -> name of directory/file

        // result should -> start with /
        // directories should be separated with only one /
        // should not end with a / unless it's the root (/)
        // shoulde exlucde any dots(./..)

        // /home/user/Documents/../Pictures" -> /home/user/Pictures
        // /.../a/../b/c/../d/./ -> /.../b/d
        // use a stack add current
        // split by / or more // /home//foo/
        // start with adding /(root)
        // add current if current . remove it -> skip
        // if current .. remove the previous element
        // if current is ... or anything else - add to stack 
        // if end of the path - remove /
        // 

*/