package com.example.demo.service;

import com.example.demo.controller.business.request.BusinessRequest;
import com.example.demo.entity.Business;
import com.example.demo.repository.BusinessRepository; // Asegúrate de tener este repositorio
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private UserService userService;

    // Método para crear un nuevo negocio
    public Business createBusiness(BusinessRequest businessRequest) {

        Business business = new Business();
        business.setBusinessName(businessRequest.businessName());
        business.setRuc(businessRequest.ruc());
        business.setAddress(businessRequest.address());
        business.setReasonSocial(businessRequest.reasonSocial());
        business.setComercialName(businessRequest.comercialName());
        business.setCategory(businessRequest.category());
        business.setUser(userService.getUserById(businessRequest.userId()).get());
        return businessRepository.save(business);
    }

    // Método para obtener todos los negocios
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    // Método para obtener un negocio por su ID
    public Optional<Business> getBusinessById(Long id) {
        return businessRepository.findById(id);
    }
}
