package database;

import database.table.Customer;
import database.table.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class create_tableTest {

    @Test
    void login_test() {
        create_table table = new create_table();
        Customer customer = table.customer;
        Staff staff = table.staff;
        table.login_test(customer, staff, "Scar", "abcdef", "staff01", "abcdef");
    }

    @Test
    void forget_password_test() {

        create_table table = new create_table();
        Customer customer = table.customer;
        Staff staff = table.staff;
        table.forget_password_test(customer, staff, "Scar", "Dobby", "Professor", "Black");

    }
}