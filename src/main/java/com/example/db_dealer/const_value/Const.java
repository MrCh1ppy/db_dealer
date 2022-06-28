package com.example.db_dealer.const_value;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public final class Const {
	public static final int NUM=10000;
	public static final String[] charSet=new String[63];

	public static final Path prefix=Path.of("data");

	static {

		int cur=0;
		for (int i = 0; i < 10; i++) {
			charSet[cur]=String.valueOf(i);
			cur++;
		}
		char temp='A';
		for (int i = 0; i < 26; i++) {
			charSet[cur]= String.valueOf(temp);
			temp++;
			cur++;
		}
		charSet[62]="Z";
	}
}
