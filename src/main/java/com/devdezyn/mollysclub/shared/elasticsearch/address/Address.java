package com.devdezyn.mollysclub.shared.elasticsearch.address;

import javax.persistence.Id;

import com.devdezyn.mollysclub.shared.models.BaseEntity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "addresses", shards = 1, replicas = 0, refreshInterval = "5s", createIndex = true)
public class Address {
  @Id
  private String zip;

  @Field(type = FieldType.Text)
  private String street;

  @Field(type = FieldType.Keyword)
  private String city;

  @Field(type = FieldType.Text)
  private String state;
  private String country;

  // Defining nested fields
  // @Field(type = FieldType.Nested, includeInParent = true)
  //   private List<Author> authors;
}
