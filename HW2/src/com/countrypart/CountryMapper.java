package com.countrypart;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountryMapper extends Mapper<Object, Text, Text, Text> {
                public void map(Object key, Text value, Context context)
                                                throws IOException, InterruptedException {
                                if (value.toString().length() > 0) {
                                                String[] tokens = value.toString().split("\t");
                                                System.out.println(tokens[0].toString() + " "
                                                                                + tokens[1].toString());
                                                System.out.println(value.toString());
                                                String gender = tokens[2].toString();
                                                String countrycensus = tokens[0] + "\t" + tokens[3];
                                                // String gendercensus = tokens[2]+"\t"+tokens[3];
                                                // the mapper emits key, value pair where the key is the gender and
                                                // the value is the other information which includes name, age and
                                                // score
                                                context.write(new Text(gender), new Text(countrycensus));
                                }
                }
}

