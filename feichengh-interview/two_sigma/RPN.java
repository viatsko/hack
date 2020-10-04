import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by XingyangChen on 10/15/16.
 */
public class RPN {
    interface Token{
        public boolean isNumber();
        public void execute(Stack<Double> s) throws Exception;
    }

    class Operand implements Token{
        private double value;
        Operand(int value){
            this.value = value;
        }
        public boolean isNumber(){
            return true;
        }
        public void execute(Stack<Double> s) throws Exception{
            s.push(value);
        }

    }

    class Opreator implements Token{
        private String type;
        Opreator(String type){
            this.type = type;
        }
        public boolean isNumber(){
            return false;
        }
        public void execute(Stack<Double> s) throws Exception {
        }
    }

    class Plus extends Opreator{
        Plus(){
            super("+");
        }
        public void execute(Stack<Double> s) throws Exception{
            if(s.isEmpty()){
                throw new Exception();
            }
            double a = s.pop();
            if(s.isEmpty()){
                throw new Exception();
            }
            double b = s.pop();
            s.push(a + b);
        }

    }

    class Mutiply extends Opreator{
        Mutiply(){
            super("*");
        }
        public void execute(Stack<Double> s) throws Exception{
            if(s.isEmpty()){
                throw new Exception();
            }
            double a = s.pop();
            if(s.isEmpty()){
                throw new Exception();
            }
            double b = s.pop();
            s.push(a * b);
        }

    }

    class TokenFactory{
        Map<String, Token> map = new HashMap<>();
        TokenFactory(){
            map.put("+", new Plus());
            map.put("*", new Mutiply());
        }
        Token create(String t){
            if(map.containsKey(t)){
                return map.get(t);
            }else{
                return new Operand(Integer.parseInt(t));
            }
        }
    }

    class Calculator{
        Stack<Double> s = new Stack<>();
        TokenFactory factory = new TokenFactory();

        public double calculate(String[] input) throws Exception{
            for(int i = 0; i < input.length;i++){
                factory.create(input[i]).execute(s);
            }
            double res = s.pop();
            if(!s.isEmpty()){
                throw new Exception();
            }
            return res;
        }
    }

}
