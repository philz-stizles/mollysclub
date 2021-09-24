// package com.devdezyn.mollysclub.shared.elasticsearch.address;

// import com.devdezyn.mollysclub.address.Address;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.elasticsearch.annotations.Query;
// import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

// public interface AddressESRepository  extends ElasticsearchRepository<Address, String> {

//     Page<Address> findByAuthorsName(String name, Pageable pageable);

//     @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
//     Page<Address> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
// }
