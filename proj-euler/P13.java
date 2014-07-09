import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class P13{

	public static void main(String[] args) throws Exception {
	//	String cat = "cattttttsssssss!";
	//	System.out.println(cat.substring(0,7));
		BigInteger sum = getSum();
		
		String result = String.valueOf(sum);
		String want = result.substring(0,10);

		System.out.println(want);

	}
	
	public static BigInteger getSum() throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader("sum.txt"));

		BigInteger sum = BigInteger.valueOf(0);
		String line="";
		BigInteger longg;

		while ((line=reader.readLine())!=null) {
		//parse is primitive, valueOf is non-primitive.
		//_long = long.parselong(line, 16);
			String value = line.substring(0,50);
			//longg = Long.parseLong(value);//.longValue();
			longg = new BigInteger(value, 10);;
			sum=sum.add(longg);
		}

		reader.close();
		
		return sum;
	}	
	
}
