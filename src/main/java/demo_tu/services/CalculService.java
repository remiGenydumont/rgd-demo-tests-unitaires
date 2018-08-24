package demo_tu.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo_tu.exception.CalculException;

public class CalculService {
	private static final Logger LOG = LoggerFactory.getLogger(CalculService.class);

	public int additionner(String expression) throws CalculException{
		int result = 0;

		LOG.debug("Evaluation de l'expression "+expression);
		boolean valid = expression.matches("[0-9]+(\\+[0-9]+)*");
		if(valid){
			String[] expSplit = expression.split("\\+");
			for (String s : expSplit) {
				result += Integer.parseInt(s);
			}
		}else{
			throw new CalculException();
		}
		return result;
	}
}

