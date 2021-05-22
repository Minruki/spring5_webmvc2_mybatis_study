package spring5_webmvc2_mybatis_study.exception;

@SuppressWarnings("serial")
public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}

}
