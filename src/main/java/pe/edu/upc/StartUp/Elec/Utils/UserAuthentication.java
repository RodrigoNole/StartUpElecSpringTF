package pe.edu.upc.StartUp.Elec.Utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pe.edu.upc.StartUp.Elec.Business.Crud.CustomerService;
import pe.edu.upc.StartUp.Elec.Business.Crud.EmployeeService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Entity.Employee;
import pe.edu.upc.StartUp.Elec.Model.Entity.Segment;
import pe.edu.upc.StartUp.Elec.security.MyUserDetails;

@Service
public class UserAuthentication {
	
	// Cambiar los service de acuerdo al segmento que tengan
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmployeeService employeeService;
	
	public boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken) { // Si no hay nadie autenticado
			return false;			
		} else {
			return true;
		}
	}
	public void getSegment(Model model) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if(!(authentication instanceof AnonymousAuthenticationToken)) {	// Si Hay alguien autenticado
				
				MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
				model.addAttribute("segment", myUserDetails.getSegment());
				
				// Para el segmento 1: Cambiar STUDENT por su segmento
				if (myUserDetails.getSegment().equals(Segment.CUSTOMER)) {
					if (customerService.existsById(myUserDetails.getIdSegment())) {
						Optional<Customer> optional = customerService.findById(myUserDetails.getIdSegment());
						model.addAttribute("student", optional.get());
					}					
				} 
				// Para el segmento 2: Cambiar TEACHER por su segmento
				else if (myUserDetails.getSegment().equals(Segment.EMPLOYEE)) {
					if (employeeService.existsById(myUserDetails.getIdSegment())) {
						Optional<Employee> optional = employeeService.findById(myUserDetails.getIdSegment());
						model.addAttribute("teacher", optional.get());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Integer getIdSegment() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {	// Si Hay alguien autenticado
			
			MyUserDetails myUserDetails = (MyUserDetails)authentication.getPrincipal();
			return myUserDetails.getIdSegment();
		}
		return null;
	}
	
}
