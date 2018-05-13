package org.badcoding.spring.controller;

import org.badcoding.dao.interfaces.ContractDAO;
import org.badcoding.dao.interfaces.CustomerDAO;
import org.badcoding.dao.interfaces.TariffDAO;
import org.badcoding.hibernate.stored.Contract;
import org.badcoding.hibernate.stored.Customer;
import org.badcoding.hibernate.stored.Tariff;
import org.badcoding.spring.form.ContractForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class ContractController {

    @Autowired
	ContractDAO contractDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    TariffDAO tariffDAO;

	private Boolean is_admin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (session.getAttribute("is_admin") != null);
	}

	@RequestMapping("/contract")
	public String contract(HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		model.put("contractForm", new ContractForm());
		return "/admin/contract";
	}

	@RequestMapping(value = "/contract_search", method = RequestMethod.GET)
	public String contract_search(@ModelAttribute ContractForm contractForm, HttpServletRequest request, Map<String, Object> model) {
		List<Integer> errors = new ArrayList<Integer>();
		List<Contract> result = new ArrayList<Contract>();
		if (!is_admin(request)) {
			errors.add(45);
			model.put("e", errors);
			return "redirect:/index";
		}
		try {

            Integer id = contractForm.getId();
			String phoneNumber = contractForm.getPhoneNumber();

            if (id == null)
                id = -1;
            /*
			if (!id_s.equals("") && (!first_name.equals("") || !last_name.equals("") || !company_s.equals("") || !address.equals("") || !email.equals("") || !personal_or_comm.equals("") || !passport.equals(""))) {
				errors.add(46);
				throw new Exception();
			}


			if (flight_s == "")
				flight_s = "-1";
			if (company_s == "")
				company_s = "-1";
			if (paid_s == "")
				paid_s = "-1";
			*/

            if (id != -1) {
				Contract t = contractDAO.getContractById(id);
				if (t != null)
					result.add(t);
			} else {
				result = contractDAO.listContracts();
			}
			if (result.size() == 0) {
				errors.add(48);
				model.put("info", errors);
			} else {
				model.put("results", result);
			}

		} catch (Exception e) {
			model.put("errors", errors);
		}
		model.put("contractForm", contractForm);
		return "/admin/contract";
	}

	@RequestMapping(value="/add_contract", method=RequestMethod.POST)
	public @ResponseBody List<Integer> add_contract(HttpServletRequest request, ContractForm contractForm) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}

            Integer id = contractForm.getId();
            Integer customerId = contractForm.getCustomerId();
            Integer tariffId = contractForm.getTariffId();
            String phoneNumber = contractForm.getPhoneNumber();
            Integer balance = contractForm.getBalance();

/*
			Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (!email_regex.matcher(email).matches())
                errors.add(24);

			if (password.length() < 8)
				errors.add(21);
			if (name.length() < 4)
				errors.add(22);
			if (last_name.length() < 4)
				errors.add(23);

			if (users.getByEmail(email).size() != 0)
				errors.add(25);
*/
            Contract contract = new Contract();

            contract.setContractId(id);
            contract.setCustomer(customerDAO.getCustomerById(customerId));
            contract.setTariff(tariffDAO.getTariffById(tariffId));
            contract.setPhoneNumber(phoneNumber);
            contract.setBalance(balance);
            contract.setRegisterDate(Calendar.getInstance().getTime());
            contractDAO.addContract(contract);

		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/get_contract", method=RequestMethod.GET)
	public @ResponseBody List<List<String>> get_contract(HttpServletRequest request, @RequestParam int contract_id) {
		List<String> errors = new ArrayList<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		try {
			if (!is_admin(request)) {
				errors.add("45");
				throw new Exception();
			}
			Contract contract = contractDAO.getContractById(contract_id);
			if (contract == null) {
				errors.add("48");
				throw new Exception();
			}

			List<String> t = new ArrayList<String>();

			t.add(Integer.toString(contract.getContractId()));
			/*
			Customer cust = contract.getCustomer();
			t.add(cust.getFirstName());
            t.add(cust.getLastName());
            */
			t.add(Integer.toString(contract.getCustomer().getCustomerId()));
            //Tariff tar = contract.getTariff();
            //t.add(tar.getName());
            t.add(Integer.toString(contract.getTariff().getTariffId()));
            t.add(contract.getPhoneNumber());
            t.add(Integer.toString(contract.getBalance()));
            //DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            //t.add(df.format(contract.getRegisterDate()));
			result.add(t);
			result.add(errors);

		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add("43");
			result.add(errors);
		}
		return result;
	}

	@RequestMapping(value="/remove_contract", method=RequestMethod.POST)
	public @ResponseBody List<Integer> remove_contract(HttpServletRequest request, Integer contract_id) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}
			Contract contract = contractDAO.getContractById(contract_id);
			if (contract == null) {
				errors.add(50);
				throw new Exception();
			}
			contractDAO.removeContract(contract);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}

	@RequestMapping(value="/edit_contract", method=RequestMethod.POST)
	public @ResponseBody List<Integer> edit_contract(HttpServletRequest request, ContractForm contractForm) {
		List<Integer> errors = new ArrayList<Integer>();
		try {
			if (!is_admin(request)) {
				errors.add(45);
				throw new Exception();
			}

            if (!is_admin(request)) {
                errors.add(45);
                throw new Exception();
            }

            Integer id = contractForm.getId();
            Integer customerId = contractForm.getCustomerId();
            Integer tariffId = contractForm.getTariffId();
            String phoneNumber = contractForm.getPhoneNumber();
            Integer balance = contractForm.getBalance();
            Date registerDate = Calendar.getInstance().getTime();


            /*
			Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (!email_regex.matcher(email).matches())
                errors.add(24);

			if (password.length() < 8)
				errors.add(21);
			if (name.length() < 4)
				errors.add(22);
			if (last_name.length() < 4)
				errors.add(23);

			if (users.getByEmail(email).size() != 0)
				errors.add(25);

            */
            Contract contract = contractDAO.getContractById(id);
            contract.setBalance(balance);

            contractDAO.updateContract(contract);
		} catch (Exception e) {
			if (errors.size() == 0)
				errors.add(43);
		}
		return errors;
	}
}

