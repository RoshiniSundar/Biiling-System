import java.io.*;
import java.util.*;
import javax.swing.*;

public class Beverages_Billing
{
	public static void main(String[] args)
	{	
		for(int i=0; i<5; i++){
			Map<String, Double> flavours = new HashMap<String, Double>();
			Map<String, Double> sizes = new HashMap<String,Double>();
			sizes.put("Small",1.50);
			sizes.put("Medium",2.50);
			sizes.put("Large",3.25);
			String name = JOptionPane.showInputDialog("Welcome! \n Please Enter your name: ");
			if (name != null){
			handleException(name);
			// System.out.println(name);
			String beverage=chooseBeverage();
			// System.out.println(beverage);
			String size=chooseSize(beverage);
			System.out.println(size);
			String flavour=chooseFlavour(beverage);
			System.out.println(flavour);

			double cost = 0;
			String output= "For " + name + ", a " +size + " " + beverage;
			cost+=sizes.get(size);		
			
			if(beverage == "Coffee" && flavour != "None"){
				flavours.clear();
				flavours.put("Vanilla",  0.25);
				flavours.put("Chocolate",  0.75);
				cost+=flavours.get(flavour);
				output+= ", with " + flavour + " flavour";
			}
			else if(beverage == "Tea" && flavour != "None"){
				flavours.clear();
				flavours.put("Lemon",  0.25);
				flavours.put("Mint",  0.50);
				cost+=flavours.get(flavour);
				output+= ", with " + flavour;
			}
			else{
				output+= ", No flavouring";
			}

			cost*=(1.13);
			// System.out.println(cost);
			cost =  Math.round(cost * 100.0) / 100.0;
			output+=", Cost: $"+ String.valueOf(cost);
			JOptionPane.showMessageDialog(null, output);
		}		
		}
		else{
			System.exit(0);
		}
	};
	
	public static String chooseBeverage(){
		String beverage= JOptionPane.showInputDialog("What would you like to have today? Coffee or tea?").toLowerCase();
		handleException(beverage);
		if(beverage.equals("c") || beverage.equals("coffee")){			
				return "Coffee";
		}
		else if (beverage.equals("t") ||  beverage.equals("tea")){
				return "Tea";
		}
		else{
			showMessageAndExit("Invalid input for beverage type");	
		}
		return "";	
	}
	
	public static String chooseSize(String beverage){
		String size= JOptionPane.showInputDialog("In What size would you like to have your " + beverage + ", Small? Medium? Large?").toLowerCase();
		handleException(size);
		if(size.equals("s") || size.equals("small")){			
				return "Small";
		}
		else if (size.equals("m") ||  size.equals("medium")){
				return "Medium";
		}
		else if (size.equals("l") ||  size.equals("large")){
				return "Large";
		}
		else{
			showMessageAndExit("Invalid input for beverage size");
		}
		return "";
	}
	
	public static String chooseFlavour(String beverage){
		
		if(beverage.equals("Coffee")){
			String flavour= JOptionPane.showInputDialog("Would you like any flavours in your " + beverage + ", Vanilla? or Chocolate?").toLowerCase();
			handleException(flavour);
			if(flavour.equals("v") || flavour.equals("vanilla")){			
				return "Vanilla";
			}
			else if (flavour.equals("c") ||  flavour.equals("chocolate")){
				return "Chocolate";
			}
			else if(flavour.equals("none")){
				return "None";
			}
			else{
				showMessageAndExit("Invalid input for flavouring");
			}
		}
		else{
			String flavour= JOptionPane.showInputDialog("Would you like any flavours in your " + beverage + ", Lemon? or Mint?").toLowerCase();
			handleException(flavour);
			if(flavour.equals("l") || flavour.equals("lemon")){			
				return "Lemon";
			}
			else if (flavour.equals("m") ||  flavour.equals("mint")){
				return "Mint";
			}
			else if(flavour.equals("none")){
				return "None";
			}
			else{	
				showMessageAndExit("Invalid input for flavouring");		
			}
		}
		return "";
	}	
	
	private static void showMessageAndExit(String msg){
		JOptionPane.showMessageDialog(null, msg);
		System.exit(1);
	}
	
	private static void handleException(String str){
		if(str.isEmpty())
			System.exit(0);
	}
}

