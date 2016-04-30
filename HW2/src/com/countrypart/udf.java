package com.countrypart;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class udf extends EvalFunc<String>{

	@Override
	public String exec(Tuple tuple) throws IOException {
		// TODO Auto-generated method stub
		if(tuple==null || tuple.size()==0)
			return null;
		try{
			
		}
		catch(Exception ex){
			
		}
		return null;
	}

}
