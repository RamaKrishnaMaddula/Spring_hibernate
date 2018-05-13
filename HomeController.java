package com.krishnas.hms.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.krishnas.hms.entity.CareTaker;
import com.krishnas.hms.entity.Doctor;
import com.krishnas.hms.entity.DoctorDetail;
import com.krishnas.hms.entity.Patient;
import com.krishnas.hms.entity.Sickness;
import com.krishnas.hms.entity.SicknessDescription;
import com.krishnas.hms.service.CaretakerService;
import com.krishnas.hms.service.DoctorService;
import com.krishnas.hms.service.PatientService;
import com.krishnas.hms.service.SicknessService;

@Controller
@RequestMapping("/application")
public class HomeController {
	
	//Annotate class as controller
	
	//request map the class as application
	
	//define the method to show the home page
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private SicknessService sicknessService;
	
	@Autowired
	private CaretakerService caretakerService;
	
	@RequestMapping("/home")
	public String showHomePage(Model theModel) {
		System.out.println("reached method");
		return "home-page";
	}
	
	@RequestMapping("/showDoctorsPage")
	public String showDoctorsPage(Model theModel) {
		System.out.println("reached method showDoctorsPage");
		List<Doctor> theDoctors = doctorService.listDoctors();
		theModel.addAttribute("doctors", theDoctors);
		System.out.println(theDoctors);
		return "doctors-page";
	}
	
	@GetMapping("/ShowFormForDoctorAdd")
	public String showFormForDoctorAdd(Model theModel){
		
		Doctor theDoctor = new Doctor();
		theModel.addAttribute("doctor",theDoctor);
		return "doctor-form";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor, Model theModel) {
		
		 Doctor theDoctorSaved = doctorService.saveDoctor(theDoctor);
		 System.out.println(theDoctorSaved);
        theModel.addAttribute("doctor", theDoctorSaved);
        DoctorDetail theDoctorDetail = new DoctorDetail();
        theModel.addAttribute("doctorDetail",theDoctorDetail);
		return "doctor-detail-form";
		}
	
	@PostMapping("/saveDoctorAdditional")
	public String saveDoctorAdditional(@RequestParam int id, @ModelAttribute DoctorDetail doctorDetail) {
		doctorService.addDoctorDetails(id,doctorDetail);
		return "redirect: showDoctorsPage";
	}
	
	@RequestMapping("/showPatientsPage")
	public String showPatientsPage(Model theModel) {
		//System.out.println("reached method showPatientsPage");
		//System.out.println("something going wrong over here");
		List<Patient> thePatients = patientService.listPatients();
		theModel.addAttribute("patients", thePatients);
		System.out.println("At the home controller: "+thePatients);
		return "patients-page";
	}
	
	@RequestMapping("/ShowFormForPatientAdd")
	public String showFormForPatientAdd(Model theModel) {
		Patient thePatient = new Patient();
		theModel.addAttribute("patient", thePatient);
		return "patient-form";
	}
	
	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute Patient thePatient, Model theModel) {
		Patient thePatientSaved=
		patientService.savePatient(thePatient);
		List<Doctor> doctors = doctorService.listDoctors();
		List<Sickness> sickness =sicknessService.listSickness();
		List<CareTaker> caretakers = caretakerService.listCaretaker();
		theModel.addAttribute("doctors", doctors);
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("patient",thePatientSaved);
		theModel.addAttribute("caretakers", caretakers);
		return "patient-case-form";
	}

	@PostMapping("/additionalPatientDetails")
	public String additionalPatientDetails(@RequestParam("pat_id")int p_id, @RequestParam("sick_id")int[] s_id, 
			@RequestParam("doc_id")int d_id, @RequestParam("ctaker_id") int c_id) {
		
		System.out.println(s_id+" "+d_id+" "+c_id+" "+p_id);
		patientService.additionalPatientDetails(p_id,s_id,d_id,c_id);
		return "redirect: showPatientsPage";
		
	}
	
	@GetMapping("/showSicknessPage")
	public String showSicknessPage(Model theModel) {
		System.out.println("At controller method");
		List<Sickness> sickness = sicknessService.listSickness();
		System.out.println(sickness);
		theModel.addAttribute("sickness",sickness);
		return "sickness-page";
	}
	
	@RequestMapping("/ShowFormForSicknessAdd")
	public String showFormForSicknessAdd(Model theModel) {
		Sickness sickness = new Sickness();
		SicknessDescription sicknessDescription = new SicknessDescription();
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("sDesc", sicknessDescription);
		
		return "sickness-form";
	}
	
	@PostMapping("/saveSickness")
	public String saveSickness(@ModelAttribute("sickness") Sickness sickness, @ModelAttribute("sDesc") SicknessDescription sDesc ) {
	    System.out.println(sickness);
		System.out.println(sDesc);

		
		sicknessService.saveSickness(sickness,sDesc);
		return "redirect: showSicknessPage";
	}
	
	@RequestMapping("/showCareTakerPage")
	public String showCareTakerPage(Model theModel) {
		List<CareTaker> theCaretakers = caretakerService.listCaretaker();
		theModel.addAttribute("caretakers", theCaretakers);
		return "caretaker-page";
	}
	
	
	@GetMapping("/ShowFormForCaretakerAdd")
	public String ShowFormForCaretakerAdd(Model theModel) {
		CareTaker caretaker = new CareTaker();
		theModel.addAttribute("caretaker", caretaker);
		return "caretaker-form";
		
	}
	
	@PostMapping("/saveCaretaker")
	public String saveCaretaker(@ModelAttribute("caretaker") CareTaker caretaker) {
	
		caretakerService.saveCareTaker(caretaker);
		return "redirect: showCareTakerPage";
	}
	
	@GetMapping("/showDoctorDetail")
	public String showDoctorDetail(@RequestParam("doctorId") int id, Model theModel) {
		Doctor theDoctor = doctorService.getDoctorDetail(id);
		DoctorDetail doctorDetail = doctorService.getDoctorContact(theDoctor);
		theModel.addAttribute("doctorDetail", doctorDetail);
		theModel.addAttribute("doctor", theDoctor);
				return "doctor-details-view";
	}
	
	  
	@GetMapping("/showDoctorPatients")
	public String showDoctorPatients(@RequestParam("doctorId") int id,Model theModel) {
		List<Patient> doctorPatients = doctorService.getDoctorPatients(id);
		Doctor doctor = doctorService.getDoctorDetail(id);
		List<Patient> patients = patientService.listPatients();
		System.out.println(doctor+"you needed");
		System.out.println(doctorPatients);
		theModel.addAttribute("doctorPatients", doctorPatients);
		theModel.addAttribute("doctor", doctor);
		theModel.addAttribute("allPatients", patients);
		return "doctor-patients-page";
	  }
	
	@GetMapping("/showDoctorSickness")
	public String showDoctorSickness(@RequestParam("doctorId")int id,Model theModel) {
		System.out.println(id);
		Doctor doctor = doctorService.getDoctorDetail(id);
		List<Sickness> sickness = doctorService.listDoctorSickness(id);
		List<Sickness> allSickness = sicknessService.listSickness();
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("doctor", doctor);
		theModel.addAttribute("allSickness", allSickness);
		return "doctor-sickness-page";
	}
	
	@GetMapping("/showUpdateDoctorForm")
	public String showUpdateDoctorForm(@RequestParam("doctorId")int id,Model theModel) {
		Doctor theDoctor = doctorService.getDoctorDetail(id);
		System.out.println(theDoctor);
		theModel.addAttribute("doctor", theDoctor);
		DoctorDetail theDoctorDetail = theDoctor.getDoctorDetail();
		System.out.println(theDoctorDetail);
		theModel.addAttribute("doctorDetail", theDoctorDetail);
		return "doctor-update-form";
	}
	
	@RequestMapping("/updateDoctor")
	public String updateDoctor(@ModelAttribute("doctr")Doctor doctor, 
			@ModelAttribute("doctorDetail")DoctorDetail doctorDetail) {
		doctorService.updateDoctorDetail(doctor,doctorDetail);
		System.out.println(doctor);
		System.out.println(doctorDetail);
		return "redirect: showDoctorsPage";
	}
	
	
	@GetMapping("/showPatientDetail")
	public String showPatientDetail(@RequestParam("patientId") int id,Model theModel) {
		System.out.println(id);
		Patient patient = patientService.getPatientDetail(id);
		theModel.addAttribute("patient", patient);
		List<Sickness> sickness = patientService.getPatientSickness(patient);
		theModel.addAttribute("sickness", sickness);
		CareTaker caretaker = patientService.getPatientCaretaker(patient);
		theModel.addAttribute("caretaker", caretaker);
		Doctor doctor = patientService.getPatientDoctor(patient);
		theModel.addAttribute("doctor", doctor);
		return "patient-details-view";
	}
	
	@GetMapping("/updatePatientForm")
	public String updatePatientForm(@RequestParam("patientId") int id, Model theModel) {
		System.out.println(id);
		Patient patient = patientService.getPatientDetail(id);
		theModel.addAttribute("patient", patient);
		List<Sickness> sickness = sicknessService.listSickness();
		theModel.addAttribute("sickness", sickness);
		System.out.println(sickness);
		List<CareTaker> caretaker = caretakerService.listCaretaker();
		theModel.addAttribute("caretakers", caretaker);
		List<Doctor> doctor = doctorService.listDoctors();
		System.out.println(doctor);
		theModel.addAttribute("doctor", doctor);
		return "patient-update-form";
	}
	
	
	@PostMapping("/updatePatient")
	public String updatePatient(@ModelAttribute("patient") Patient patient, 
			@RequestParam("pat_id") int pat_id, @RequestParam("doc_id") int doc_id, @RequestParam("ctaker_id") int c_id) {
		System.out.println(patient);
		System.out.println(pat_id);
		System.out.println(doc_id);
		System.out.println(c_id);
		patientService.updatePatient(patient,pat_id,doc_id,c_id);

		
		return "redirect: showPatientsPage";
	}
	
	@GetMapping("/showSicknessDetail")
	public String showSicknessDetail(@RequestParam("sicknessId") int id, Model theModel) {
		System.out.println(id);
		Sickness sickness = sicknessService.getSicknessDetails(id);
		SicknessDescription sicknessDescription = sicknessService.getSicknessDescription(sickness);
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("sicknessDescription",sicknessDescription);
		return "sickness-details-view";
	}
	
	@RequestMapping("/updateSicknessForm")
	public String updateSicknessForm(@RequestParam("sicknessId") int id, Model theModel) {
	
		
		Sickness sickness = sicknessService.getSicknessDetails(id);
		SicknessDescription sicknessDescription = sicknessService.getSicknessDescription(sickness);
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("sicknessDescription",sicknessDescription);
		return "sickness-update-form";
	}
	
	@PostMapping("updateSickness")
	public String updateSickness(@ModelAttribute("sickness") Sickness sickness, 
			@ModelAttribute("sicknessDescription") SicknessDescription sicknessDescription) {
		System.out.println(sickness);
		System.out.println(sicknessDescription);
		sicknessService.updateSickness(sickness,sicknessDescription);
		return "success";
	}
	
	@GetMapping("/sicknessDoctors")
	public String sicknessDoctors(@RequestParam("sicknessId") int id, Model theModel) {
		List<Doctor> doctorList = sicknessService.getSicknessDoctors(id);
		List<Doctor> allDoctors = doctorService.listDoctors();
		Sickness sickness = sicknessService.getSicknessDetails(id);
		System.out.println(doctorList);
		theModel.addAttribute("doctors",doctorList);
		theModel.addAttribute("allDoctors", allDoctors);
		theModel.addAttribute("sickness", sickness);
		return "sickness-doctors-page";
	}
	
	@GetMapping("/addDoctorToSickness")
	public String addDoctorToSickness(@RequestParam("sickId") int sick_id, 
			@RequestParam("doctorId") int doc_id, Model theModel){

		sicknessService.addDoctorToSickness(sick_id,doc_id);
		theModel.addAttribute("sicknessId", sick_id);
		return "redirect: sicknessDoctors";
		
	}
	
	
	@GetMapping(("/addSicknessToDoctor"))
	public String addSicknessToDoctor(@RequestParam("sicknessId") int sick_id,
			@RequestParam("doctorId") int doc_id, Model theModel ) {
		
		sicknessService.addDoctorToSickness(sick_id,doc_id);
		theModel.addAttribute("doctorId", doc_id);
		return "redirect: showDoctorSickness";
	}
	
	@GetMapping("/addPatientToDoctor")
	public String addPateintToDoctor(@RequestParam("patientId") int pat_id,
			@RequestParam("doctorId") int doc_id, Model theModel ) {
		patientService.addPatientToDoctor(pat_id,doc_id);
		theModel.addAttribute("doctorId", doc_id);
		return "redirect: showDoctorPatients";
	}
	
	@GetMapping("/sicknessPatients")
	public String sicknessPatients(@RequestParam("sicknessId") int id,Model theModel) {
		List<Patient> patients = sicknessService.getSicknessPatients(id);
		Sickness sickness = sicknessService.getSicknessDetails(id);
		List<Patient> allPatients = patientService.listPatients();
		theModel.addAttribute("patients",patients);
		theModel.addAttribute("sickness", sickness);
		theModel.addAttribute("allPatients", allPatients);
		return "sickness-patients";
	}
	
	@GetMapping("/addPatientToSickness")
	public String addPatientToSickness(@RequestParam("patientId") int pat_id,
			@RequestParam("sicknessId") int sick_id, Model theModel ) {
		patientService.addPatientToSickness(pat_id,sick_id);
		
		theModel.addAttribute("sicknessId", sick_id);
		return "redirect: sicknessPatients";
	}
	
	@GetMapping("/showCaretakerDetail")
	public String showCaretakerDetail(@RequestParam("caretakerId") int id, Model theModel) {
		CareTaker caretaker = caretakerService.getCaretakerDetails(id);
		theModel.addAttribute("caretaker", caretaker);
		return "caretaker-details-page";
		
	}
	
	@GetMapping("/showCaretakerUpdateForm")
	public String showCaretakerUpdateForm(@RequestParam("caretakerId")int ctaker_id,Model theModel) {
		
		CareTaker caretaker = caretakerService.getCaretakerDetails(ctaker_id);
		theModel.addAttribute("caretaker", caretaker);
		System.out.println(caretaker);
		return "caretaker-update-form";
		}
	
	
	@PostMapping("/updateCaretaker")
	public String updateCaretaker(@ModelAttribute("caretaker") CareTaker caretaker, Model theModel) {
		int id = caretakerService.updateCaretaker(caretaker);
		
		theModel.addAttribute("caretakerId", id);
		return "caretaker-details-page";
		
	}
	
	@GetMapping("/caretakerPatients")
	public String caretakerPatients(@RequestParam("caretakerId") int id, Model theModel) {
		System.out.println(id);
		CareTaker caretaker = caretakerService.getCaretakerDetails(id);
		List<Patient> caretakerPatients = caretakerService.getCaretakerPatients(id);
		System.out.println(caretakerPatients);
		List<Patient> allPatients = patientService.listPatients();
		theModel.addAttribute("patientsList", caretakerPatients);
		theModel.addAttribute("caretaker", caretaker);
		theModel.addAttribute("allPatients", allPatients);
		return "caretaker-patients-page";
	}
	
	
	@GetMapping("/addPatientToCaretaker")
	public String addPatientToCaretaker(@RequestParam("caretakerId") int ctaker_id, 
			@RequestParam("patientId") int pat_id, Model theModel) {
		patientService.addPatientToCaretaker(ctaker_id,pat_id);
		theModel.addAttribute("caretakerId", ctaker_id);
		return "redirect: caretakerPatients";
		
	}
}
