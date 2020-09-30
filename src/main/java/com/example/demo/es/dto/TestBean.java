//package com.example.demo.es.dto;
//
//import lombok.Data;
//
//import java.io.Serializable;
//
//@Data
//@Document(indexName = "book", type = "_doc")
//public class TestBean implements Serializable {
//    public TestBean() {
//    }
//
//    public TestBean(long id, String name, Integer age, String sex, String desc) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.sex = sex;
//        this.desc = desc;
//    }
//	// 必须指定一个id，
//    @Id
//    private long id;
//    // 这里配置了分词器，字段类型，可以不配置，默认也可
//    @Field(analyzer = "ik_smart", type = FieldType.Text)
//    private String name;
//    private Integer age;
//    @Field(analyzer = "ik_smart", type = FieldType.Text)
//    private String sex;
//	@Field(analyzer = "ik_smart", type = FieldType.Text)
//    private String desc;
//}