package fennec.khatwa.khatwa.controller;

import fennec.khatwa.khatwa.dto.ServiceDTO;
import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.service.ServiceOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/services")
public class ServiceController {

    private final ServiceOfferService serviceService;

    public ServiceController(ServiceOfferService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/get-all-services")
    public List<ServiceDTO> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping("/create-service-offer")
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDto) {
        return serviceService.createService(serviceDto);
    }
}
