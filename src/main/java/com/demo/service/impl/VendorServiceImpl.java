package com.demo.service.impl;

import com.demo.domain.Vendor;
import com.demo.repository.VendorCrudRepository;
import com.demo.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorCrudRepository vendorCrudRepository;

    @Override
    public void addVendor(Vendor vendor) {
        vendorCrudRepository.save(vendor);
    }

    @Override
    public void deleteVendor(Vendor vendor) {
        vendorCrudRepository.delete(vendor);
    }

    @Override
    public void updateVendor(Vendor vendor) {
        vendorCrudRepository.save(vendor);
    }

    @Override
    public Vendor findVendor(Long id) {
        return (Vendor)vendorCrudRepository.findOne(id);
    }
}
