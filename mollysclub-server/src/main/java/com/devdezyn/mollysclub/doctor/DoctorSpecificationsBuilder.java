// package com.devdezyn.mollysclub.doctor;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// import com.devdezyn.mollysclub.shared.utils.SearchCriteria;

// import org.springframework.data.jpa.domain.Specification;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// public class DoctorSpecificationsBuilder {
    
//     private final List<SearchCriteria> params;

//     public DoctorSpecificationsBuilder() {
//         params = new ArrayList<SearchCriteria>();
//     }

//     public DoctorSpecificationsBuilder with(String key, String operation, Object value) {
//         params.add(new SearchCriteria(key, operation, value));
//         return this;
//     }

//     public Specification<Doctor> build() {
//         if (params.size() == 0) {
//             return null;
//         }

//         List<Specification<Doctor>> specs = params.stream()
//           .map(DoctorSpecification::new)
//           .collect(Collectors.toList());
        
//         Specification<?> result = specs.get(0);

//         for (int i = 1; i < params.size(); i++) {
//             result = params.get(i)
//               .isOrPredicate()
//                 ? Specification.where(result)
//                   .or(specs.get(i))
//                 : Specification.where(result)
//                   .and(specs.get(i));
//         }       
//         return result;
//     }
// }
