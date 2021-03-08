package com.roytuts.java.custom.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class CustomAnnotationApp {

	public static void main(String[] args) {
		Class<HelloWorld> obj = HelloWorld.class;

		if (obj.isAnnotationPresent(Comments.class)) {
			Annotation annotation = obj.getAnnotation(Comments.class);
			Comments comment = (Comments) annotation;
			System.out.println("Author Name : " + comment.authorName());
			System.out.println("Created date : " + comment.createdDate());
			System.out.println("Last Modified date : " + comment.lastModifiedDate());
			System.out.println("Last Modified By : " + comment.lastModifiedBy());
			System.out.println("Reviewers : " + Arrays.toString(comment.reviewers()));
		}
	}

}
