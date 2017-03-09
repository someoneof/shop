package com.demo.service;

import com.demo.domain.Vendor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 海峰 on 2017/3/6.
 */
@Transactional
@Service
public interface VendorService {
    public void addVendor(Vendor vendor);

    public void deleteVendor(Vendor vendor);

    public void updateVendor(Vendor vendor);

    public Vendor findVendor(Long id);
}
