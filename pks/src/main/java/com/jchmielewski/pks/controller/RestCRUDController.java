package com.jchmielewski.pks.controller;

import com.jchmielewski.pks.DAO.AddressDAO;
import com.jchmielewski.pks.DAO.CentralDAO;
import com.jchmielewski.pks.DAO.PackageDAO;
import com.jchmielewski.pks.DAO.UserDAO;
import com.jchmielewski.pks.entity.Address;
import com.jchmielewski.pks.entity.Central;
import com.jchmielewski.pks.entity.Package;
import com.jchmielewski.pks.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestCRUDController {

    //DAOs
    private final AddressDAO addressDAO;
    private final CentralDAO centralDAO;
    private final PackageDAO packageDAO;
    private final UserDAO userDAO;

    @Autowired
    public RestCRUDController(AddressDAO addressDAO, CentralDAO centralDAO, PackageDAO packageDAO, UserDAO userDAO) {
        this.addressDAO = addressDAO;
        this.centralDAO = centralDAO;
        this.packageDAO = packageDAO;
        this.userDAO = userDAO;
    }

    //Address
    @GetMapping("/address/{id}")
    public Address getAddress(@PathVariable int id){
        return addressDAO.getById(id);
    }

    @GetMapping("/address")
    public List<Address> getAddresses(){
        return addressDAO.getAll();
    }

    @PostMapping("/address")
    public void saveAddress(@RequestBody Address address){
        address.setId(0);
        addressDAO.saveOrUpdate(address);
    }

    @PutMapping("/address")
    public void updateAddress(@RequestBody Address address){
        addressDAO.saveOrUpdate(address);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable int id){
        addressDAO.delete(id);
    }


    //Central
    @GetMapping("/central/{id}")
    public Central getCentral(@PathVariable int id){
        return centralDAO.getById(id);
    }

    @GetMapping("/central")
    public List<Central> getCentrals(){
        return centralDAO.getAll();
    }

    @PostMapping("/central")
    public void saveCentral(@RequestBody Central central){
        central.setId(0);
        centralDAO.saveOrUpdate(central);
    }

    @PutMapping("/central")
    public void updateCentral(@RequestBody Central central){
        centralDAO.saveOrUpdate(central);
    }

    @DeleteMapping("/central/{id}")
    public void deleteCentral(@PathVariable int id){
        centralDAO.delete(id);
    }


    //Package
    @GetMapping("/package/{id}")
    public Package getPackage(@PathVariable int id){
        return packageDAO.getById(id);
    }

    @GetMapping("/package")
    public List<Package> getPackages(){
        return packageDAO.getAll();
    }

    @PostMapping("/package")
    public void savePackage(@RequestBody Package tempPackage){
        tempPackage.setId(0);
        packageDAO.saveOrUpdate(tempPackage);
    }

    @PutMapping("/package")
    public void updatePackage(@RequestBody Package tempPackage){
        packageDAO.saveOrUpdate(tempPackage);
    }

    @DeleteMapping("/package/{id}")
    public void deletePackage(@PathVariable int id){
        packageDAO.delete(id);
    }

    //User
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return userDAO.getById(id);
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userDAO.getAll();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        user.setId(0);
        userDAO.saveOrUpdate(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
        userDAO.saveOrUpdate(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userDAO.delete(id);
    }
}
