package com.example.db_dealer.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.StringJoiner;

@Getter
@Accessors(chain = true)
@AllArgsConstructor
public class UserData{
		String vaccinationDate;
		String vaccinationId;
		String vaccine_code;
		String idCardNo;
		String name;
		String idCardType;
		Integer vaccineSeq;
		String sfjzwc;
		String push_time;
		String etl_time;
		String option_1;
		String record_status;
		String lastupdate_time;

	@Override
	public String toString() {
		return new StringJoiner(",")
				.add(check(vaccinationDate))
				.add(check(vaccinationId))
				.add(check(vaccine_code))
				.add(check(idCardNo))
				.add(check(name))
				.add(check(idCardType))
				.add(check(vaccineSeq.toString()))
				.add(check(sfjzwc))
				.add(check(push_time))
				.add(check(etl_time))
				.add(check(option_1))
				.add(check(record_status))
				.add(check(lastupdate_time))
				.toString();
	}

	private String check(String target){
		return target;
	}
}
