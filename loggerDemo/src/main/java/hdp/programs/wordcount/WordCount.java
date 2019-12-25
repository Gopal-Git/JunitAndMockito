package hdp.programs.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import hdp.programs.wordcount.mapper.WordCountMapper;
import hdp.programs.wordcount.reducer.WordCountReducer;

public class WordCount {
	public static void main(String[] args) {
		
		if (args.length != 2) {
			System.out.println("Invalid arguments ");
			System.out.println("Provide input output file paths");
		}
		Configuration config = new Configuration();
		try {
			Job job = new Job(config, "WordCountJob");
			job.setJarByClass(WordCount.class);
			job.setJobName("Word_Count");
			
			System.out.println(args[0]+" " +args[1]);
			
			FileInputFormat.addInputPath(job, new Path(args[0]));
			FileOutputFormat.setOutputPath(job, new Path(args[1]));
			job.setMapperClass(WordCountMapper.class);
			job.setReducerClass(WordCountReducer.class);
			// Output key class of reducer
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			System.exit(job.waitForCompletion(true)?0:1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
