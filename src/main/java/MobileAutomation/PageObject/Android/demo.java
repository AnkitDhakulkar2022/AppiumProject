package MobileAutomation.PageObject.Android;

public class demo {
	public static void main(String[] args) {
		String s= "This is java program";
		String rev="";
		String s1=s.replaceAll(" ", "");
		System.out.println(s1);
		
		for(int i=s1.length()-1;i>=0;i--)
		{
			rev=rev+s1.charAt(i);
		}
		System.out.println(rev);
	}

}
