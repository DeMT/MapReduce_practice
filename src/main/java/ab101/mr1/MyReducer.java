package ab101.mr1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text, NullWritable> {
	int count =0 ;
	
	String timeIn = "";
	String timeOut = "";
	String user ="";
	Text result = new Text();
	String temp ="";
	
	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Context arg2)
			throws IOException, InterruptedException {
		// System.out.println(arg0);
		Iterator<Text> it = arg1.iterator();

		
		while (it.hasNext()) {
			
			String action = it.next().toString().trim();
			
			// //
			if (action.equals("in")) {
				count = 0 ;
				System.out.println("in benn call");
				user = arg0.toString().split(",")[0];							
				timeIn = arg0.toString().split(",")[1];
				temp = user+","+timeIn;
				
				
				
			} else if (action.equals("out")) {
//				System.out.println(action);
				System.out.println("out benn call");
				timeOut = arg0.toString().split(",")[1];
				result.set(user+","+timeIn+","+timeOut+","+count);
				arg2.write(result, null);
			}			
			 else{
			 int a = Integer.parseInt(action);
			 
			 count = count+a;			 
			 
			 
			 //
			 //
			
			 }
			
		}
		
		System.out.println(result.toString());
		
		// TODO Auto-generated method stub
		// super.reduce(arg0, arg1, arg2);
	}

	@Override
	protected void setup(Reducer<Text, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("I'am grouping "+context.getTaskAttemptID());
		super.setup(context);
	}

}
