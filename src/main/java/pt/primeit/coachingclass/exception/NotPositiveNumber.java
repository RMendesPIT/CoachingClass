package pt.primeit.coachingclass.exception;

import org.springframework.context.MessageSource;

import pt.primeit.coachingclass.util.MessagesEnum;

public class NotPositiveNumber extends RulesException {

	private static final long serialVersionUID = 1L;

	public NotPositiveNumber(MessageSource messageSource) {

		super(MessagesEnum.NOT_POSITIVE_NUMBER, messageSource);
	}

}
