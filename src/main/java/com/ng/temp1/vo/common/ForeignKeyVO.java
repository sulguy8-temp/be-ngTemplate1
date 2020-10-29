package com.ng.temp1.vo.common;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("fk")
public class ForeignKeyVO {
	private String referencedTableName;
	private String referencedColumnName;
	
}
