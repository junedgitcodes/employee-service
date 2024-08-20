package com.seliniumexpress.employeeapp.EmployeeDao;

import com.seliniumexpress.employeeapp.Model.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public interface AddressDao {

     AddressResponse getAddressByEmployeeId(int id) throws Exception;
}
