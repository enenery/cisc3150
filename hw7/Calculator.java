import java.util.*;
import java.lang.*;

public class Calculator{

	public static void calculate(String input[]) throws LookAtMrAlgebraOverHereException, IllegalOperationException, UserIsADumbassException{

		if(input.length < 1)
			throw new UserIsADumbassException();

		Stack<Double> nums = new Stack();
		Stack<Character> opes = new Stack();
		Stack<Character> pares = new Stack();

		double right, left, result;
		char middle;
		int dotUsed = 0;

		for(int i = 0; i < input.length; i++){

			if(input[i].charAt(0) == '-'){
				if(1 < input[i].length()){
					for(int j = 1; j < input[i].length(); j++)
					if(!Character.isDigit(input[i].charAt(j))){
						if(dotUsed == 0 && input[i].charAt(j) == '.')
							dotUsed++;
						else
							throw new LookAtMrAlgebraOverHereException();
					}
						dotUsed = 0;
						nums.push(Double.parseDouble(input[i]));

					}else
						opes.push('-');		

				}				
			else{
				if(Character.isDigit(input[i].charAt(0))){
					for(int j = 1; j < input[i].length(); j++)
						if(!Character.isDigit(input[i].charAt(j))){
							if(dotUsed == 0 && input[i].charAt(j) == '.')
								dotUsed++;
							else
								throw new LookAtMrAlgebraOverHereException();
						}

						dotUsed = 0;
						nums.push(Double.parseDouble(input[i]));

					if(nums.size() == 2  && !opes.empty() && pares.empty()){
						if(opes.peek() == '@' || opes.peek() == '/' || opes.peek() == '%'){
							right = nums.pop();
							left = nums.pop();
							middle = opes.pop();
							if(right == 0 && middle == '/')
								throw new ArithmeticException();
							result = 0;

							switch(middle){
								case '@':
									result = left * right;
									break;
								case '/':
									result = left / right;
									break;
								case '%':
									result = left % right;
									break;
								default:
									break;
							}

							nums.push(result);
						}
					}
				}else{

					if(input[i].length() > 1){
						throw new IllegalOperationException();
					}

					if(input[i].charAt(0) == '(')
						pares.push(input[i].charAt(0));
					else{
						if(input[i].charAt(0) == ')'){
							if(!pares.empty()){
								pares.pop();
								if(nums.size() > 1 && opes.size() > 0){
									right = nums.pop();
									left = nums.pop();
									middle = opes.pop();
									if(right == 0 && middle == '/')
										throw new ArithmeticException();
									result = 0;

									switch(middle){
										case '+':
											result = left + right;
											break;
										case '-':
											result = left - right;
											break;
										case '@':
											result = left * right;
											break;
										case '/':
											result = left / right;
											break;
										case '%':
											result = left % right;
											break;
										default:
											break;
									}
									nums.push(result);
								}

							}
							else
								throw new IllegalOperationException();
						}else{
							if(input[i].charAt(0) == '@' || input[i].charAt(0) == '/' || input[i].charAt(0) == '%')
								opes.push(input[i].charAt(0));
							else{
								if(input[i].charAt(0) == '+' || input[i].charAt(0) == '-'){

									if(pares.empty() && !opes.empty()){
										if(opes.peek() == '@' || opes.peek() == '/' || opes.peek() == '%'){
										right = nums.pop();
										left = nums.pop();
										middle = opes.pop();
										if(right == 0 && middle == '/')
											throw new ArithmeticException();
										result = 0;

										switch(middle){
											case '@':
												result = left * right;
												break;
											case '/':
												result = left / right;
												break;
											case '%':
												result = left % right;
												break;
											default:
												break;
										}

										nums.push(result);
										}
									}

									opes.push(input[i].charAt(0));
								}
							}
						}
					}
				}
			}

		}

		if(!pares.empty())
			throw new IllegalOperationException();
		else{
			while(nums.size() > 1 && opes.size() > 0){
				right = nums.pop();
				left = nums.pop();
				middle = opes.pop();
				if(right == 0 && middle == '/')
					throw new ArithmeticException();
				result = 0;

				switch(middle){
					case '+':
						result = left + right;
						break;
					case '-':
						result = left - right;
						break;
					case '@':
						result = left * right;
						break;
					case '/':
						result = left / right;
						break;
					case '%':
						result = left % right;
						break;
					default:
						break;
				}

				nums.push(result);
			}
			
				if(opes.size() > 0)
					throw new LookAtMrAlgebraOverHereException();

				if(nums.size() == 1)
					System.out.println(nums.pop());
				else
					throw new IllegalOperationException();
		}
	}

	public static void main(String args[]){
		calculate(args);
	}
}

class LookAtMrAlgebraOverHereException extends IllegalArgumentException {
	public LookAtMrAlgebraOverHereException(){
		super("Expected a number and found something else.");
	}
}

class IllegalOperationException extends IllegalArgumentException {
	public IllegalOperationException(){
		super("An illegal operation entered or incorrect parenthesizing.");
	}
}

class UserIsADumbassException extends IllegalArgumentException {
	public UserIsADumbassException(){
		super("Please enter some expression for calculation.");
	}
}