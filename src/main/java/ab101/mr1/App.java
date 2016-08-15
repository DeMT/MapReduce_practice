package ab101.mr1;



import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException, InterruptedException
    {
        Path input = new Path("HDFS/input/");
        Path output = new Path("HDFS/output");
        
        Configuration conf = new Configuration();
        FileSystem fs =FileSystem.get(conf);
        fs.delete(output, true);
        Job job = Job.getInstance(conf);
        job.setInputFormatClass(TextInputFormat.class);
        FileInputFormat.setInputPaths(job, input);
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setGroupingComparatorClass(MyGroupingComparator.class);
        job.setPartitionerClass(Partitioner.class);
        job.setReducerClass(MyReducer.class);
        job.setNumReduceTasks(2);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setJarByClass(job.getMapperClass());        
        FileOutputFormat.setOutputPath(job, output);
        boolean success = job.waitForCompletion(true);
    }
}
