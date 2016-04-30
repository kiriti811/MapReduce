package com.countrypart;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//The data belonging to the same partition go to the same reducer. In a particular partition, all the values with the same key are iterated and the person with the maximum score is found.
//Therefore the output of the reducer will contain the male and female maximum scorers in each of the 3 age categories.
// the type parameters are the input keys type, the input values type, the
// output keys type, the output values type
public class CountryReducer extends Reducer<Text, Text, Text, Text> {
                int census, pcount = 0;

                @Override
                public void reduce(Text key, Iterable<Text> values, Context context)
                                                throws IOException, InterruptedException {
                                // int maxScore = Integer.MIN_VALUE;
                                String gender = " ";
                                // String census = " ";
                                // String gender = " ";

                                // iterating through the values corresponding to a particular key
                                for (Text val : values) {
                                                String[] valTokens = val.toString().split("\t");
                                                pcount = Integer.parseInt(valTokens[1]);
                                                census = pcount + census;
                                                // if the new score is greater than the current maximum score,
                                                // update the fields as they will be the output of the reducer after
                                                // all the values are processed for a particular key

                                }
                                gender = key.toString();
                                context.write(new Text(gender), new Text("census- " + census));
                                pcount = 0;
                                census = 0;
                }

}
