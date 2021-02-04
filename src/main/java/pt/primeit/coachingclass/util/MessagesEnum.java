package pt.primeit.coachingclass.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public enum MessagesEnum {

	//MATH RULES
	NOT_POSITIVE_NUMBER("MATH001"),

	//ERRORS
	UNEXPECTED_ERROR("ERROR000");

	private String code;

	MessagesEnum(String code) {

		this.code = code;
	}

	public String getCode() {

		return code;
	}

	public String getMessage(MessageSource messageSource) {

		return messageSource.getMessage(this.code, null, LocaleContextHolder.getLocale());
	}


}
