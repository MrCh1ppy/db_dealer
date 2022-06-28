package com.example.db_dealer.task;


import com.example.db_dealer.const_value.Const;
import com.example.db_dealer.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
@Slf4j
@RequiredArgsConstructor
public class OutPutTask  implements InitializingBean{
	final TaskService taskService;


	public void afterPropertiesSet() {
		ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		try {
			if(!Const.prefix.toFile().exists()){
				Files.createDirectory(Const.prefix);
			}
		} catch (IOException e) {
			log.info("创建prefix失败");
		}

		String[] charSet = Const.charSet;
		for (int i = 0; i < charSet.length; i++) {
			for (int j = 0; j < charSet.length-1; j++) {
				String temp = charSet[j+1];
				if("0".equals(temp)||"A".equals(temp)){
					continue;
				}
				String left = charSet[i] + charSet[j];
				String right = charSet[i] + charSet[j + 1];
				executorService.execute(()->taskService.doService(left,right));
				log.info("in{}-{}",left,right);
			}
		}
	}
}

