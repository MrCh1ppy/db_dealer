package com.example.db_dealer.service.impl;

import com.example.db_dealer.code.sz.CodingUtils;
import com.example.db_dealer.const_value.Const;
import com.example.db_dealer.dao.Dao;
import com.example.db_dealer.pojo.UserData;
import com.example.db_dealer.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
@Slf4j
public class Impl implements TaskService {
	private final Dao dao;
	@Override
	public void doService(String left, String right) {
		String temp = left.substring(1);
		log.info("do {}",left);
		if("9".equals(temp)||"Z".equals(temp)){
			return;
		}
		File file = Const.prefix.resolve(left + ".txt").toFile();
		try(
				FileOutputStream stream = new FileOutputStream(file,true)
		) {
			int limit=1;
			while (true){
				List<UserData> list;
				list=dao.selectRecord(left, right, (limit-1) * Const.NUM);
				StringJoiner joiner = new StringJoiner("\n");
				list.stream()
						.map(cur->cur.setName(CodingUtils.codeDeal(cur.getName())))
						.map(cur->cur.setIdCardNo(CodingUtils.codeDeal(cur.getIdCardNo())))
						.forEach(cur-> joiner.add(cur.toString()));
				String text = joiner.toString();
				stream.write(text.getBytes(StandardCharsets.UTF_8));
				if(list.size()<Const.NUM){
					log.info("写入{}条数据{}",(limit-1)*Const.NUM+ list.size(),left);
					return;
				}
				limit++;
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
