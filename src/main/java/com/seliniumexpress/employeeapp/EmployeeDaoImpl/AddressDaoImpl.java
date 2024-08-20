package com.seliniumexpress.employeeapp.EmployeeDaoImpl;

import com.seliniumexpress.employeeapp.EmployeeDao.AddressDao;
import com.seliniumexpress.employeeapp.Model.AddressResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AddressDaoImpl implements AddressDao {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${address-api.url}")
    private String addressApiUrl;

    private static final String ADDRESS_URL = "/address/{id}";

//    public AddressDaoImpl( @Value("${address-api.url}")  String addressApiUrl, RestTemplateBuilder builder) {
//        this.restTemplate = builder
//                .rootUri(addressApiUrl)
//                .build();
//    }

    @Override
    public AddressResponse getAddressByEmployeeId(int id) throws Exception {
        AddressResponse addressResponse = null;
        try {
            String url = addressApiUrl + ADDRESS_URL;
            addressResponse = restTemplate.getForObject(url, AddressResponse.class, id);
        } catch (Exception ex) {
           log.error("Error While calling Address Service");
        }
        return addressResponse;
    }
}
