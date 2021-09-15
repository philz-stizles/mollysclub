// package com.devdezyn.mollysclub.shared;

// import java.io.Serializable;

// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.MappedSuperclass;

// import lombok.Getter;
// import lombok.Setter;

// @Getter
// @Setter
// // @MappedSuperclass annotation can be mapped in the same way as an entity except that 
// // the mappings will apply only to its subclasses since no table exists for the mapped 
// // superclass itself. When applied to the subclasses the inherited mappings will apply 
// // in the context of the subclass tables. Mapping information may be overridden in such 
// // subclasses by using the AttributeOverride and AssociationOverride annotations or 
// // corresponding XML elements.
// @MappedSuperclass
// public class User extend BaseEntity {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
// }
