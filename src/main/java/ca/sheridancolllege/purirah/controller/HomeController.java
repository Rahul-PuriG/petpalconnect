package ca.sheridancolllege.purirah.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancolllege.purirah.bean.Donor;
// import ca.sheridancolllege.purirah.bean.Pet;
import ca.sheridancolllege.purirah.bean.Event;
import ca.sheridancolllege.purirah.Email.EmailServiceImpl;
import ca.sheridancolllege.purirah.Repositories.DonorRepositories;
import ca.sheridancolllege.purirah.Repositories.EventRepositories;
// import ca.sheridancolllege.purirah.Repositories.PetRepositories;
import lombok.AllArgsConstructor;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class HomeController {

    @Autowired
	private EmailServiceImpl esi;
    // private final PetRepositories petRepo;
    private final DonorRepositories donorRepo;
    private final EventRepositories eventRepo;

    
    @GetMapping("/")
    public String root(Model model) {
        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // boolean isLoggedIn = authentication != null && authentication.isAuthenticated();

        // model.addAttribute("loggedIn", isLoggedIn);
        return "index.html";
    } 

    // donors
    
    
    @GetMapping("/addDonor")
    public String addDonor(Model model) {
        model.addAttribute("donor", new Donor());
        return "AddDonor.html";
    }

    @PostMapping("/addDonor")
    public String addDonor(@ModelAttribute Donor donor) {
        try {
            String to = donor.getDonorEmail(); 
            donorRepo.addDonor(donor);

            List<Donor> donors =donorRepo.getDonors();
            int id = donors.size();

            esi.sendMailWithInline(to, "Thank You for Your Generous Donation!", "Donor", donorRepo.getDonorById(id), "Thank you");
            return "redirect:/addDonor";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception or use a proper logging mechanism
            return "error"; // Redirect to an error page or return an error view
        }
    }
    

    @GetMapping("/listDonors")
    public String listDonors(Model model) {
        model.addAttribute("donors", donorRepo.getDonors());
        return "ListDonors.html";
    }

    // Event

    @GetMapping("/addEvent")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "AddEvent.html";
    }

    @PostMapping("/addEvent")
    public String processAdd(@ModelAttribute Event event) throws Exception {
        String to = event.getEmail();
        eventRepo.addEvent(event);

        List<Event> events =eventRepo.getEvents();
        int id = events.size();

        esi.sendMailWithInline(to,"Event Confirmation","Event",eventRepo.getEventById(id),"Thank you");
        return "redirect:/addEvent";
    }

    @GetMapping("/listEvents")
    public String viewAccountants(Model model) {
        model.addAttribute("events", eventRepo.getEvents());
        return "ListEvents.html";
    }

    //Pet

    // @GetMapping("/addPet")
    // public String addPetForm(Model model) {
    //     model.addAttribute("pet", new Pet());
    //     return "AddPet.html";
    // }

    // @PostMapping("/addPet")
    // public String processAddPet(@ModelAttribute Pet pet) {
    //     petRepo.addPet(pet);
    //     return "redirect:/addPet";
    // }

    // @GetMapping("/listPets")
    // public String listPets(Model model) {
    //     model.addAttribute("pets", petRepo.getPet());
    //     return "ListPets.html";
    // }

    // @GetMapping("/petNews")
    // public String petNews() {
    //     return "AnimalsNews.html";
    // }
    

}
