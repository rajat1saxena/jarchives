import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.Date;

public class utctolocal{
	public static void main(String args[]){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssZ");
		String output = format.format(date);
		System.out.println(output);
		try{
			Date date2 = format.parse(output);
			format.setTimeZone(TimeZone.getTimeZone("UTC"));
			System.out.println(format.format(date2));
		}catch(Exception e){
			// do nothing
			e.printStackTrace();
		}
	}
}