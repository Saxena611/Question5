import java.util.*; 

public class Question5 
{ 
	public static int calc(String s) 
	{ 
		char[] arr = s.toCharArray(); 
 
		Stack<Integer> val = new Stack<>(); 
		Stack<Character> ops = new Stack<>(); 

		for (int i = 0; i < arr.length; i++) 
		{ 
			 
			if (arr[i] == ' ') 
				continue; //There can be spaces in b/w

			 
			if (arr[i] >= '0' && arr[i] <= '9') 
			{ 
				StringBuffer s1 = new StringBuffer(); 
				//Two or Three digit number 
				while (i < arr.length && arr[i] >= '0' && arr[i] <= '9') 
					s1.append(arr[i++]); 
				val.push(Integer.parseInt(s1.toString()));//String to integer 
			} 

			
			else if (arr[i] == '(') 
				ops.push(arr[i]); 

			
			else if (arr[i] == ')') 
			{ 
                //Found a closing brace lets search for its opening val
                //pop over the value coming in between
                while (ops.peek() != '(') 
				val.push(operation(ops.pop(), val.pop(), val.pop())); 
				ops.pop(); 
			} 

			//making it follow bodmas 
			else if (arr[i] == '+' || arr[i] == '-' || 
					arr[i] == '*' || arr[i] == '/') 
			{ 
				
				while (!ops.empty() && check(arr[i], ops.peek())) 
				val.push(operation(ops.pop(), val.pop(), val.pop())); 
 
				ops.push(arr[i]); 
			} 
		} 

		//For the remaining
		while (!ops.empty()) 
			val.push(operation(ops.pop(), val.pop(), val.pop())); 

		
		return val.pop(); //output 
	} 

	public static boolean check(char v1, char v2) 
	{ 
		if (v1 == '(' || v2 == ')') 
			return false; 
		if ((v1 == '*' || v1 == '/') && (v2 == '+' || v2 == '-')) 
			return false; 
		else
			return true; 
	} 

	
	public static int operation(char operation, int b, int a) 
	{ 
		switch (operation) 
		{ 
		case '+': 
			return a + b; 
		case '-': 
			return a - b; 
		case '*': 
			return a * b; 
		case '/': 
			if (b == 0) 
                System.out.println("Cannot divide by zero");
                System.exit(0); 
			return a / b; 
		} 
		return 0; 
	} 

	
	public static void main(String[] args) 
	{ 
		
		System.out.println(Question5.calc("((2*3)+4/(5*2))*4)")); 

	} 
}
