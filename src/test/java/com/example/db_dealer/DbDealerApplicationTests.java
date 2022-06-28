package com.example.db_dealer;

import com.example.db_dealer.code.sz.CodingUtils;
import com.example.db_dealer.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class DbDealerApplicationTests {
	@Resource
	TaskService taskService;
	@Resource
	ThreadPoolTaskExecutor threadPoolExecutor;

	@Test
	public void test() throws IOException {


		try{
			String text = CodingUtils.sm3Encode("654322199511180040");
			System.out.println("////////////////////////////////////////////////////"+text);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
