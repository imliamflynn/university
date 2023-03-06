package dao;

import domain.Customer;


/**
 *
 * @author liamflynn
 */
public interface CustomerDAO {

    void saveCustomer(Customer customer);

    Customer getCustomer(String username);

    Boolean validateCredentials(String username, String password);

}
