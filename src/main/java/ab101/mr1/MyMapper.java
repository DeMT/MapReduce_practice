package ab101.mr1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{
	Text userTime = new Text();
	Text actionOrPrice = new Text();
	
	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void map(LongWritable key, Text value,Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException  {
		// TODO Auto-generated method stub
		String[] keyStr =  value.toString().split(" ");
		
		userTime.set(keyStr[0]+","+keyStr[1]);
		actionOrPrice.set(keyStr[2]);
		context.write(userTime, actionOrPrice);
	}


	
}
