package fennec.khatwa.khatwa.service;


import fennec.khatwa.khatwa.dto.ServiceDTO;
import fennec.khatwa.khatwa.model.ServiceCategory;
import fennec.khatwa.khatwa.model.ServiceOffer;
import fennec.khatwa.khatwa.repository.ServiceCategoryRepository;
import fennec.khatwa.khatwa.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceOfferService {

    private final ServiceRepository serviceRepository;

    private final ServiceCategoryRepository categoryRepository;

    public ServiceOfferService(ServiceRepository serviceRepository, ServiceCategoryRepository categoryRepository) {
        this.serviceRepository = serviceRepository;
        this.categoryRepository = categoryRepository;
    }

    public ServiceDTO createService(ServiceDTO serviceDto) {
        // Find category by ID
        ServiceCategory category = categoryRepository.findById(serviceDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Create ServiceOffer entity
        ServiceOffer offer = new ServiceOffer();
        offer.setName(serviceDto.getName());
        offer.setDescription(serviceDto.getDescription());
        offer.setCategory(category);

        // Save and map back to DTO
        ServiceOffer saved = serviceRepository.save(offer);
        return mapToDto(saved);
    }

    public List<ServiceDTO> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    private ServiceDTO mapToDto(ServiceOffer offer) {
        ServiceDTO dto = new ServiceDTO();
        dto.setId(offer.getId());
        dto.setName(offer.getName());
        dto.setDescription(offer.getDescription());
        dto.setCategoryId(offer.getCategory().getId());
        return dto;
    }
}
