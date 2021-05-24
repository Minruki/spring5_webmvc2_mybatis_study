package spring5_webmvc2_mybatis_study.exception;

@SuppressWarnings("serial")
public class DupulicateMemberException extends RuntimeException{

	public DupulicateMemberException(String message) {
		super(message);
	}
}