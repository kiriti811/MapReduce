package com.countrypart;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CountryPartitioner extends Partitioner<Text, Text> {
                public int getPartition(Text key, Text value, int numReduceTasks) {
                                String[] countrycensus = value.toString().split("\t");
                                String country = countrycensus[0];
                                // int census = Integer.parseInt(age);
                                System.out.println(numReduceTasks);
                                System.out.println(country);
                                // this is done to avoid performing mod with 0
                                if (numReduceTasks == 0)
                                                return 0;
                               
                                if (country.equals("France")) {
                                                return 0;
                                }
                                if (country.equals("Spain")) {
                                                return 1 % numReduceTasks;
                                } else

                                {
                                                return 2 % numReduceTasks;
                                }

                }
}
