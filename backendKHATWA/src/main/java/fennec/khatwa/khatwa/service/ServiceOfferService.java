package fennec.khatwa.khatwa.service;


import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferService {

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceOffer createService(ServiceOffer service) {
        return serviceRepository.save(service);
    }

    public List<ServiceOffer> getAllServices() {
        return serviceRepository.findAll();
    }
}