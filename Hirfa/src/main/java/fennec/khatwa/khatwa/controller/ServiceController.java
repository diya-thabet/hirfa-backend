package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.service.ServiceOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/services")
public class ServiceController {

    @Autowired
    private ServiceOfferService serviceService;

    @GetMapping
    public List<ServiceOffer> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping
    public ServiceOffer TPScreateService(@RequestBody ServiceOffer service) {
        return serviceService.createService(service);
    }
}