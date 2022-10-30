
public class main {


    public static void main(String[] args  ){

        System.out.println("Resultado: "+ (Solution.isValid("()") ? "Valid" : "Invalid"));
        System.out.println("Resultado: "+ (Solution.isValid("()[]{}") ? "Valid" : "Invalid"));
        System.out.println("Resultado: "+ (Solution.isValid("(]") ? "Valid" : "Invalid"));
        System.out.println("Resultado: "+ (Solution.isValid("([)]") ? "Valid" : "Invalid"));
        System.out.println("Resultado: "+ (Solution.isValid("{[]}") ? "Valid" : "Invalid"));
    }

    public static class Solution{

        public static boolean isValid(String s){

            boolean result = true;



            result = solveBracketsMustBeClosedByTheSameType(s, result);
            result = solveBracketsMustBeClosedInTheCorrectOrder(s, result);


            return result;
        }

        private static boolean solveBracketsMustBeClosedInTheCorrectOrder(String s, boolean result) {
            for(int i = 0; i< s.length(); i++){

                if(s.charAt(i) == '(' &&  s.charAt(i+1) == '}'){
                    result = false;
                }

                if(s.charAt(i) == '(' &&  s.charAt(i+1) == ']'){
                    result = false;
                }


                if(s.charAt(i) == '{' &&  s.charAt(i+1) == ')'){
                    result = false;
                }

                if(s.charAt(i) == '{' &&  s.charAt(i+1) == ']'){
                    result = false;
                }

                if(s.charAt(i) == '[' &&  s.charAt(i+1) == '}'){
                    result = false;
                }

                if(s.charAt(i) == '[' &&  s.charAt(i+1) == ')'){
                    result = false;
                }

            }
            return result;
        }

        private static boolean solveBracketsMustBeClosedByTheSameType(String s, boolean result) {
            for(int i = 0; i< s.length(); i++){

                if(s.charAt(i) == '(' &&  s.charAt(i+1) != ')'){
                    result = false;
                }

                if(s.charAt(i) == '{' &&  s.charAt(i+1) != '}'){
                    result = false;
                }


                if(s.charAt(i) == '[' &&  s.charAt(i+1) != ']'){
                    result = false;
                }

            }
            return result;
        }


    }


}
