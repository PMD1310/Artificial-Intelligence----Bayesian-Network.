/* Pramod Kemisetty
 * 1001570333
 * Part 2
*/
import java.util.ArrayList;

public class BayesianNetwork {

	ArrayList<String> generate_values(ArrayList<String> variables)
	{
		ArrayList<String> result=new ArrayList<String>(10);
		if(variables.contains("Bt"))
			result.add(0,"true");
		else if(variables.contains("Bf"))
			result.add(0,"false");
		else
			result.add(null);
		if(variables.contains("Et"))
			result.add(1,"true");
		else if(variables.contains("Ef"))
			result.add(1,"false");
		else
			result.add(null);
		if(variables.contains("At"))
			result.add(2,"true");
		else if(variables.contains("Af"))
			result.add(2,"false");
		else
			result.add(2,null);
		
		if(variables.contains("Jt"))
			result.add(3,"true");
		else if(variables.contains("Jf"))
			result.add(3,"false");
		else
			result.add(3,null);
		
		if(variables.contains("Mt"))
			result.add(4,"true");
		else if(variables.contains("Mf"))
			result.add(4,"false");
		else
			result.add(4,null);
		
		//System.out.println(result);
		return result;
	}

	double different_patterns(ArrayList<String> variables)
	{
			ArrayList<String> new_variables=new ArrayList<String>();
			int noneId;
			if(!variables.contains(null)) {
				//System.out.println(variables);
				return compute_probability(variables.get(0),variables.get(1),variables.get(2),variables.get(3),variables.get(4));
			}
			else {
				noneId=variables.indexOf(null);
				//System.out.println("New_variables");
				for(int i1=0;i1<variables.size();i1++)
				{
					new_variables.add(i1,variables.get(i1));
				}
				new_variables.set(noneId,"true");
				//System.out.println(new_variables);
				double val1=different_patterns(new_variables);
				new_variables.set(noneId,"false");
				//System.out.println(new_variables);
				double val2=different_patterns(new_variables);
				return (val1+val2);
			}
	}
	double compute_probability(String b, String e, String a, String j, String m) {
		/*System.out.println(b);
		System.out.println(e);
		System.out.println(a);
		System.out.println(j);
		System.out.println(m);
		System.out.println(Prob("B",b,null,null));
		System.out.println(Prob("E",e,null,null));
		System.out.println(Prob("A|B,E",a,b,e));
		System.out.println(Prob("J|A",j,a,null));
		System.out.println(Prob("M|A",m,a,null));*/
		double result=(Prob("B",b,null,null)*Prob("E",e,null,null)*Prob("A|B,E",a,b,e)*Prob("J|A",j,a,null)*Prob("M|A",m,a,null));
		return result;
	}
	
	double Prob(String q, String v1, String v2, String v3) {
		if(q.equalsIgnoreCase("B"))
		{
			if(v1.equalsIgnoreCase("True"))
				return (0.001);
			else
				return (0.999);
		}
		if(q.equalsIgnoreCase("E"))
		{
			if(v1.equalsIgnoreCase("True"))
				return (0.002);
			else
				return (0.998);
		}
		
		if(q.equalsIgnoreCase("A|B,E")) {
			double temp=0.0;
			if(v2.equals("true") && v3.equals("true")) {
				temp=0.95;
			}
			else if(v2.equals("true") && v3.equals("false")) {
				temp=0.94;
			}
			else if(v2.equals("false") && v3.equals("true")) {
				temp=0.29;
			}
			else if(v2.equals("false") && v3.equals("false")) {
				temp=0.001;
			}
			if(v1.equals("true")) {
				return temp;
			}
			else
				return (1-temp);
		}
		if(q.equalsIgnoreCase("J|A")) {
			double temp=0.0;
			if(v2.equalsIgnoreCase("true")) {
				temp=0.90;
			}
			else 
				temp=0.05;
			if(v1.equalsIgnoreCase("true"))
				return temp;
			else
				return (1-temp);
			}
		if(q.equalsIgnoreCase("M|A")) {
			double temp=0.0;
			if(v2.equalsIgnoreCase("true"))
				temp=0.70;
			else 
				temp=0.01;
			if(v1.equalsIgnoreCase("true"))
				return temp;
			else
				return (1-temp);
		}
		return -1;
	}
}
