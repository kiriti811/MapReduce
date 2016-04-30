package A.pig.one;

import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.WrappedIOException;

@SuppressWarnings("deprecation")
public class lowercase extends EvalFunc<String> {

	public String exec(Tuple input) throws IOException {

		if (input == null || input.size() == 0)

			return null;

		try {

			String str = (String) input.get(0);

			str = str.toLowerCase();

			return str;

		} catch (Exception e) {

			throw WrappedIOException.wrap(
					"Caught exception processing input row ", e);

		}
	}
}