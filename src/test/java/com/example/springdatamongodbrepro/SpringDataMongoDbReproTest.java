package com.example.springdatamongodbrepro;

import java.math.BigDecimal;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
class SpringDataMongoDbReproTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void throws_on_unset() {
		this.mongoTemplate.updateMulti(
			new Query(),
			new Update()
				.unset("field"),
			Entity.class
		);
	}

	public static class Entity {
		private ObjectId id;
		@Field(targetType = FieldType.DECIMAL128)
		private BigDecimal field;
	}
}
