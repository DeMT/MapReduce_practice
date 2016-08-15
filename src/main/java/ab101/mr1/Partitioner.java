package ab101.mr1;

import java.util.Objects;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;


public class Partitioner extends HashPartitioner<Text,Text>{
	Text user = new Text(); 

	@Override
	public int getPartition(Text key, Text value, int numReduceTasks) {
			user.set(key.toString().split(",")[0]);
			int hashUser =Objects.hash(user) ;
			
		return super.getPartition(user, value, numReduceTasks);
	}


}
