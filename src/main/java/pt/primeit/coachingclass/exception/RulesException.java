package pt.primeit.coachingclass.exception;

import org.springframework.context.MessageSource;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pt.primeit.coachingclass.util.MessagesEnum;

@Data
@EqualsAndHashCode(callSuper = false)
public class RulesException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	protected final String message;

	protected final String erroCode;

	public RulesException(MessagesEnum error, MessageSource messageSource) {

		this.erroCode = error.getCode();
		this.message = error.getMessage(messageSource);
	}

}
