/* Pramod Kemisetty
 * 1001570333
 * Part 2
*/

import java.util.*;
public class Assignment6part2{
	public static void main(String args[]) {
	if( args.length == 0 ||args.length > 6 ) 
    {
      System.out.println(" error -- number of arguments should be between 1 and 6");
      System.exit(0);
     }
	
	boolean given=false;
	ArrayList<String> observation=new ArrayList<String>();
	ArrayList<String> query=new ArrayList<String>();
	//String[] argv_value= {"Bt","Af","Mf","Jt","Ef"};
	for(int i =0;i<args.length;i++ )
	{
		if(args[i]=="given")
		{
			given=true;
			continue;
		}
		query.add(args[i]);
		if(given==true)
		{
			observation.add(args[i]);
		}
	}
	BayesianNetwork bnet=new BayesianNetwork();
	double numerator,denominator;
	if(!query.isEmpty()) {
		  numerator = bnet.different_patterns(bnet.generate_values(query));
		  //System.out.printf("%.9f",numerator);
		  if(!observation.isEmpty()) {
			  denominator=bnet.different_patterns(bnet.generate_values(observation));
			  //System.out.println(denominator);
		  }
		  else
			  denominator=1;
		  System.out.printf("Probability is %.9f",(numerator/denominator));
	}
	else
		System.out.println("Invalid Query String");
}}