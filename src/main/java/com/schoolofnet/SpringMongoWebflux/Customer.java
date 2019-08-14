package com.schoolofnet.SpringMongoWebflux;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Customer {

	@Id
	public String id;
	public String name;
}
