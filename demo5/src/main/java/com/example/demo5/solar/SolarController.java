package com.example.demo5.solar;

import com.example.demo5.solar.entities.Client;
import com.example.demo5.solar.entities.UsefulEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/solar")
@CrossOrigin("*")
public class SolarController {

    @GetMapping("clientbyid/{id}")
    public Client ClientByIdSolar(@PathVariable("id") int id) throws Exception{
        return Fonction.getClientById(id);
    }

    @GetMapping("listeclient")
    public ArrayList<Client> listeClientSolar() throws Exception{
        return Fonction.getListClient();
    }

    @GetMapping("loginclient/{email}/{pass}")
    public UsefulEntity loginClientSolar(@PathVariable("email") String email, @PathVariable("pass")String pass) throws Exception{
        return Fonction.loginClient(email,pass);
    }

    @GetMapping("insertclient/{email}/{pass}")
    public void insertClientSolar(@PathVariable("email") String email, @PathVariable("pass")String pass) throws Exception{
        Fonction.signUpClient(email,pass);
    }

    @GetMapping("insertdonnee/{voltage}/{courant}/{energie}/{puissance}")
    public void insertDonnee(@PathVariable("voltage") String voltage, @PathVariable("courant")String courant, @PathVariable("energie")String energie, @PathVariable("puissance")String puissance) throws Exception{
        Fonction.insertDonnee(voltage,courant,energie,puissance);
    }
}