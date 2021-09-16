package com.devdezyn.mollysclub.prescription;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService{
    private final PrescriptionRepository prescriptionRepository;
    private final PrescriptionMapper prescriptionMapper;

    @Override
    public List<PrescriptionDto> getPrescriptions() {
        return prescriptionRepository.findAll()
            .stream()
            .map(a -> prescriptionMapper.toDto(a))
            .collect(Collectors.toList());
    }

}
