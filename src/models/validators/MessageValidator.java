package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Message;

public class MessageValidator {
public static List<String> validate(Message m){
	List<String> errors = new ArrayList<String>();

	String status_error = _validateStatus(m.getStatus());
	if(!status_error.equals("")){
		errors.add(status_error);
	}

	String content_error =_validateContent(m.getContent());
	if(!content_error.equals("")){
		errors.add(content_error);
	}
	return errors;
}

private static String _validateStatus(String status){
	if(status == null || status.equals("")){
		return "・タスクの状況を入力して下さい。";
	}
	return "";
}
private static String _validateContent(String content){
	if(content == null || content.equals("")){
		return "・タスクの内容を入力して下さい。";
	}
	return "";
}
}
