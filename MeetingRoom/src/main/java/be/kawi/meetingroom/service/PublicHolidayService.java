package be.kawi.meetingroom.service;


import be.kawi.meetingroom.dao.PublicHolidayDAO;
import be.kawi.meetingroom.model.PublicHoliday;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublicHolidayService {


    @Autowired
    private PublicHolidayDAO publicHolidayDAO;

    
    @Transactional
    public List<PublicHoliday> getPublicHolidays() {
        return publicHolidayDAO.getPublicHolidays();
    }

    /*
    @Transactional
    public void updateProduct(Product someProduct, Product someNewProduct) {
        if (someNewProduct.getDescription().length() > 0 || someNewProduct.getPrice() > 0.0) {

            transferData(someProduct, someNewProduct);
            synchronized (SynchronizingFlag.PRODUCT) {
                someProduct.setActive("N");
                productDAO.updateProduct(someProduct);
                productDAO.saveProduct(someNewProduct);
            }
        } else {
            throw new ProductNotChangedException("error.product.nochange");
        }
    }

   
    private void transferData(Product someProduct, Product someNewProduct) {
        if (someNewProduct.getDescription().length() == 0) {
            someNewProduct.setDescription(someProduct.getDescription());
        }
        if (someNewProduct.getPrice() == 0.0) {
            someNewProduct.setPrice(someProduct.getPrice());
        }
        someNewProduct.setMaxOrderQuantity(someProduct.getMaxOrderQuantity());
    }
    */
}
